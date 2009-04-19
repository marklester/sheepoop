package sheep.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;
import javax.swing.Timer;

import sheep.model.Model;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.view.overlays.HotBarConsole;
import sheep.view.overlays.MessageConsole;
import sheep.view.overlays.StatConsole;
import sheep.view.util.DrawInfo;
import sheep.view.util.ResourceLoader;

/**
 * Area of the screen in which the tiles are drawn and the game is played.  Has
 * a stat overlay.
 * @author Phil Freo
 */
public class AreaViewport extends JPanel {
	private static final long serialVersionUID = 8296336314571261983L;

	private boolean MAP_CREATE_MODE = false;
	private static final int PAINTS_PER_SECOND = 30;
	public  static int TILE_SIZE = 80;
	private static int widthPerTile = (int) ((TILE_SIZE / 2) * (1 + Math.tan(Math.PI / 6)));
	private static int heightPerTile = TILE_SIZE;
	private final GameMap gameMap;
	private final Model model;
	private Timer repaintTimer;
	private StatConsole stats;
	private MessageConsole messageConsole;
	private HotBarConsole hotBar;
	private HashMap<Location, BufferedImage> tilesCache = new HashMap<Location, BufferedImage>();
	private HashMap<Location, Long> tilesBirthday = new HashMap<Location, Long>();
	private HashMap<Location, Integer> tilesTimesUsed = new HashMap<Location, Integer>();
	private HashMap<String, BufferedImage> prevDrawnTile = new HashMap<String, BufferedImage>();
	private boolean isPaused = false; 

	public AreaViewport(Model model, GameMap map) {
		this.gameMap = map;
		this.model = model;
		
		if (model == null)
			throw new RuntimeException("AreaViewport was passed a null Model.");
		if (map == null)
			throw new RuntimeException("AreaViewport was passed a null GameMap.");

	}

	/**
	 * To be called when the size/location of this component has been set
	 */
	public void initialize() {

		// Create StatConsole
		this.stats = new StatConsole(20, this.getHeight() - StatConsole.getHeight() - 20, model.getAvatar());
		this.messageConsole = new MessageConsole(20, 20, model.getAvatar());
		this.hotBar = new HotBarConsole(this.getWidth() - HotBarConsole.getWidth() - 20, this.getHeight(), model.getAvatar());	
		
		// Setup swing timer for repaints
		int millisBetweenTicks = 1 / PAINTS_PER_SECOND * 1000;
		repaintTimer = new Timer(millisBetweenTicks, new TimerAction());
		repaintTimer.start(); 
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		// Paint tiles
		if (!isPaused) {
			drawTiles(g2);
		}
		
		// Paint children
		if (messageConsole.isVisible()) {
			messageConsole.paint(g2);
		}
		if (stats.isVisible()) {
			stats.paint(g2);
		}
		if (hotBar.isVisible()) {
			hotBar.paint(g2);
		}
		
	}

	private void drawTiles(Graphics2D g2) {

		Location center = model.getMover().getLocation();

		int radius = model.getAvatar().getRadiusOfVisibility();

		// Get the tiles that the Avatar can currently see completely
		Map<Location, List<Locatable>> newTiles;
		if (MAP_CREATE_MODE) {
			newTiles = gameMap.getMap();
		} else {
			newTiles = gameMap.getMapSubset(center, radius);
		}

		// Loop through each tile and get its id and orientation
		Map<Location, List<DrawInfo>> tileInfo = new HashMap<Location,List<DrawInfo>>();
		try {
			for (Entry<Location, List<Locatable>> entry : newTiles.entrySet()) {
				Location loc = entry.getKey();
				List<Locatable> locatables = entry.getValue();
				
				if (locatables.size() == 0) {
					continue;
				}
				//Create the list of DrawInfos
				tileInfo.put(loc,createTileDrawingString(loc, locatables));
				
			}
		} catch(Exception e) {
			// This is one way to stop concurrency exceptions
			System.out.println("A concurrency exception was caught.");
		}
		//for all the DrawInfos created, loop through and either draw them or get the image from the cache
		for (Entry<Location, List<DrawInfo>> entry : tileInfo.entrySet())
		{
			String drawKey = "";
			Location loc = entry.getKey();
			List<DrawInfo> drawinfos = entry.getValue();
			
			for(DrawInfo d: drawinfos)
			{
				drawKey+=d.toString()+":";
			}
			BufferedImage thisImage = prevDrawnTile.get(drawKey);
			if(thisImage == null)
			{
				thisImage = drawOneTile(drawinfos);
				prevDrawnTile.put(drawKey, thisImage);
			}
			addTotilesCache(loc, thisImage);
		}
		// Get all tile locations visible on the screen to draw, regardless of  
		// whether the Avatar can see them.  
		List<Location> locationsToDraw = new ArrayList<Location>();
		int numTilesWide = (int) (this.getWidth() / widthPerTile);
		int numTilesTall = this.getHeight() / heightPerTile;
		for (int x = -1 * numTilesWide / 2 - 1; x <= numTilesWide / 2 + 1; ++x) {
			for (int y = -1 * numTilesTall / 2 - 1; y <= numTilesTall / 2 + 1; ++y) {
				locationsToDraw.add(new Location(center.getX() + x, center.getY() + y));
			}
		}
		
		// For each location on the screen, get an image from cache and draw it
		for (Location loc : locationsToDraw) {
			BufferedImage img = getTileImage(loc);
			
			if (img == null) continue;
			
			Point pt = getTilePosition(loc, center);
			g2.drawImage(img, pt.x, pt.y, null);
			
			if (MAP_CREATE_MODE) {
				g2.setColor(Color.WHITE);
				g2.drawString(loc.getX() + "," + loc.getY(), pt.x + 25, pt.y + 40);
			}
		}
		
	}
	
	/**
	 * Return the pixel coordinates of where the top left of a tile should go.
	 * Assume the AreaViewport starts at 0,0 and that we know the TILE_SIZE
	 * which is the size in pixels of each square tile.
	 * @param loc the Location of the image, based on our hex coordinate system
	 * @param center the Location in which the Avatar lies, which should be
	 * 				 centered on the screen
	 * @return
	 */
	private BufferedImage drawOneTile(List<DrawInfo> myInfo)
	{
		BufferedImage myImage = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics2D g2 = myImage.createGraphics();
		for(DrawInfo d: myInfo)
		{
			if(d.getOrientation() == null)
			{
				g2.drawImage((BufferedImage) ResourceLoader.getInstance().getImage(d.getId()), 0, 0, null);
			}
			else
			{
				BufferedImage tempImage = (BufferedImage)ResourceLoader.getInstance().getImage(d.getId());
				AffineTransform affineT = g2.getTransform(); 
				double rotate = -1 * d.getOrientation().getAngleInRadians();
				g2.rotate(rotate, tempImage.getWidth() / 2, tempImage.getHeight() / 2);
				g2.drawImage(tempImage, 0, 0, null);
				g2.setTransform(affineT);
			}
		}
		return myImage;
	}
	private Point getTilePosition(Location loc, Location center) {
		int startX = this.getWidth() / 2 + (loc.getX() - center.getX()) * widthPerTile - (TILE_SIZE / 2);
		int startY = this.getHeight() / 2 + (loc.getY() - center.getY()) * heightPerTile - (TILE_SIZE / 2);
		int offsetY = 0;
		if (loc.getX() % 2 != 0) {
			// Odd x-positions are offset down
			offsetY = TILE_SIZE / 2;
		}
		if (center.getX() % 2 != 0) {
			// If the avatar is on an odd x-position, move everything up a lil
			offsetY -= TILE_SIZE / 2;
		}

		return new Point(startX, startY + offsetY);
	}

	/**
	 * Create a new image for a given location with its list of objects at that
	 * location.  This uses the LocationDrawingVisitor. 
	 * @param loc
	 * @param locatables
	 * @return
	 * @see LocationDrawingVisitor
	 */
	private BufferedImage createTileImage(Location loc, List<Locatable> locatables) {
		LocationDrawingVisitor v = new LocationDrawingVisitor(TILE_SIZE);

		for (Locatable locatable : locatables) {
			locatable.accept(v);
		}

		return (BufferedImage) v.getImage();

	}
	private List<DrawInfo> createTileDrawingString(Location loc, List<Locatable> locatables)
	{
		LocationStringVisitor v = new LocationStringVisitor();

		for (Locatable locatable : locatables) {
			locatable.accept(v);
		}

		return (v.getFullPicture());
	}

	/**
	 * Add a tile's image to the cache.  Sets tiles creation time here for 
	 * fog-of-war 
	 * @param loc
	 * @param img
	 */
	private void addTotilesCache(Location loc, BufferedImage img) {
		if (img != null && loc != null) {
			tilesCache.put(loc, img);
			tilesBirthday.put(loc, Calendar.getInstance().getTimeInMillis());
			tilesTimesUsed.put(loc, 0);
		}
	}

	/**
	 * Return the image in cache for the specified location.  If the location
	 * does not have a tile, return a black image. Decrement a fog-of-war 
	 * "staleness" float here
	 * @param loc
	 * @return
	 */
	private BufferedImage getTileImage(Location loc) {
		BufferedImage tile = tilesCache.get(loc);
		
		// Create a black image
		BufferedImage ret = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics2D g2 = ret.createGraphics();

		// If nothing was in the cache, return the blank image
		if (tile == null) {		
			// put a dot on totally blank tiles for testing
			g2.setColor(Color.BLUE);
			g2.drawOval(TILE_SIZE / 2, TILE_SIZE / 2, 2, 2);
			return ret;
		}
		
		// Draw the tile on our blank image
		g2.drawImage(tile, 0, 0, null);
		
		int timesUsed = tilesTimesUsed.get(loc);
		if (timesUsed > 0) {
			// Make tile faded (semi-transparent black overlay) based on age
		
			long age = Calendar.getInstance().getTimeInMillis() - tilesBirthday.get(loc);
			float percentFaded = Math.min(1, age / 4000f);	// define millis to fade to black
			percentFaded = Math.max(percentFaded, 0.4f);	// define first level of faded
			percentFaded = Math.min(percentFaded, 0.85f);	// define final level of faded
		
			BufferedImage blackImg = (BufferedImage) ResourceLoader.getInstance().getImage("BlackTile");
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, percentFaded));
			g2.drawImage(blackImg, 0, 0, null);

		}
		
		tilesTimesUsed.put(loc, timesUsed + 1);
		
		return ret;
	}
	
	public StatConsole getStatConsole() {
		return this.stats;
	}
	
	public MessageConsole getMessageConsole() {
		return this.messageConsole;
	}
	
	public HotBarConsole getHotBarConsole() {
		return this.hotBar;
	}
	
	public void stopPainting() {
		isPaused = true;
		repaintTimer.stop();
	}
	
	public void toggleGrid() {
		MAP_CREATE_MODE = !MAP_CREATE_MODE;
	}

	private class TimerAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}

	}
	
}