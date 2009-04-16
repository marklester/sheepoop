package sheep.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.Map.Entry;

import javax.swing.JPanel;
import javax.swing.Timer;

import sheep.model.Model;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.view.overlays.HotBarConsole;
import sheep.view.overlays.MessageConsole;
import sheep.view.overlays.Overlay;
import sheep.view.overlays.StatConsole;
import sheep.view.util.ResourceLoader;

/**
 * Area of the screen in which the tiles are drawn and the game is played.  Has
 * a stat overlay.
 * @author Phil Freo
 */
public class AreaViewport extends JPanel {
	private static final long serialVersionUID = 8296336314571261983L;

	private static final boolean MAP_CREATE_MODE = false;
	private static final int PAINTS_PER_SECOND = 30;
	public  static int TILE_SIZE = 80;
	private static int widthPerTile = (int) ((TILE_SIZE / 2) * (1 + Math.tan(Math.PI / 6)));
	private static int heightPerTile = TILE_SIZE;
	private final GameMap gameMap;
	private final Model model;
	private StatConsole stats;
	private MessageConsole messageConsole;
	private HotBarConsole hotBar;
	private HashMap<Location, BufferedImage> tilesCache = new HashMap<Location, BufferedImage>();
	private HashMap<Location, Float> tilesFreshness = new HashMap<Location, Float>();
	private ArrayList<Overlay> overlays;

	public AreaViewport(Model model, GameMap map) {
		this.gameMap = map;
		this.model = model;
		
		if (model == null)
			throw new RuntimeException("AreaViewport was passed a null Model.");
		if (map == null)
			throw new RuntimeException("AreaViewport was passed a null GameMap.");

		overlays = new ArrayList<Overlay>();	
	}

	/**
	 * To be called when the size/location of this component has been set
	 */
	public void initialize() {

		// Create StatConsole
		this.stats = new StatConsole(20, this.getHeight() - StatConsole.getHeight() - 20, model.getAvatar());
		this.messageConsole = new MessageConsole(20, 20, model.getAvatar());
		
		//overlays.add(hotBar);
		overlays.add(messageConsole);
		overlays.add(stats);	
		
		// Setup swing timer for repaints
		int millisBetweenTicks = 1 / PAINTS_PER_SECOND * 1000;
		Timer timer = new Timer(millisBetweenTicks, new TimerAction());
		timer.start(); 

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		// Paint tiles
		drawTiles(g2);

		// Paint children
		if (stats.isVisible())
			stats.paint(g2);
		if (messageConsole.isVisible())
			messageConsole.paint(g2);
	}

	private void drawTiles(Graphics2D g2) {

		Location center = model.getMover().getLocation();

		int radius = model.getAvatar().getRadiusOfVisibility();

		// Get the tiles that the Avatar can currently see completely
		HashMap<Location, Vector<Locatable>> newTiles;
		if (MAP_CREATE_MODE) {
			newTiles = gameMap.getMap();
		} else {
			newTiles = gameMap.getMapSubset(center, radius);
		}

		// Loop through each tile, create and cache an image for it
		try {
			for (Entry<Location, Vector<Locatable>> entry : newTiles.entrySet()) {
				Location loc = entry.getKey();
				Vector<Locatable> locatables = entry.getValue();
				
				if (locatables.size() == 0) {
					continue;
				}
				
				BufferedImage tileImage = createTileImage(loc, locatables);
				addTotilesCache(loc, tileImage);
			}
		} catch(Exception e) {
			// This is one way to stop concurrency exceptions
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

	/**
	 * Add a tile's image to the cache.  Reset fog-of-war staleness here
	 * @param loc
	 * @param img
	 */
	private void addTotilesCache(Location loc, BufferedImage img) {
		if (img != null && loc != null) {
			tilesCache.put(loc, img);
			tilesFreshness.put(loc, 1f);
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
		BufferedImage ret = tilesCache.get(loc);
		
		if (ret == null) {
			
			if (true) {
			return null;
			}
			
			// Create and return a black image
			ret = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_ARGB_PRE);
			
			// Put a dot on totally blank tiles for testing
			Graphics2D g2 = ret.createGraphics();
			g2.setColor(Color.BLUE);
			g2.drawOval(TILE_SIZE / 2, TILE_SIZE / 2, 2, 2);
			return ret;
		}
		
		// Make tile faded (semi-transparent black overlay) based on freshness
		// Note: the darkness applies each time is additive - so we only want to
		// apply a small amount of darkness since it just gets added to the 
		// previous image
		float percentFreshness = tilesFreshness.get(loc);
		if (percentFreshness < 1 && percentFreshness > 0.5) {
			Graphics2D g2 = ret.createGraphics();
			BufferedImage blackImg = (BufferedImage) ResourceLoader.getInstance().getImage("BlackTile");
			if (percentFreshness == 0.99f) {
				// Fade faster the first time
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
			} else {			
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.03f));
			}
			g2.drawImage(blackImg, 0, 0, null);
		}
		
		// Calculate and store a new staleness
		float newFreshness = percentFreshness - 0.01f;
		tilesFreshness.put(loc, newFreshness);

		return ret;
	}

	private class TimerAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}

	}
	
	public void toggleVisibility() {
		//We don't want to toggle Areaviewport...
	}
	
	public StatConsole getStatConsole() {
		return this.stats;
	}
	
	public MessageConsole getMessageConsole() {
		return this.messageConsole;
	}

//	@Override
//	public void paint(Graphics2D g) {
//		super.paint(g);
//	}
	
}