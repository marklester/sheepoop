package sheep.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JPanel;

import sheep.model.entities.Avatar;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.view.overlays.StatConsole;

public class AreaViewport extends JPanel {
	private static final long serialVersionUID = 8296336314571261983L;

	private LocationDrawingVisitor locationDrawingVisitor;
	private final GameMap gameMap;
	private Avatar avatar;
	private StatConsole stats;
	private HashMap<Location, BufferedImage> tileCache = new HashMap<Location, BufferedImage>();

	public AreaViewport(Avatar avatar, GameMap map) {
		this.gameMap = map;
		this.avatar = avatar;
		
		if (avatar == null) {
//			throw new RuntimeException("AreaViewport was passed a null Avatar.");
		}
		
		if (map == null) {
//			throw new RuntimeException("AreaViewport was passed a null GameMap.");
		}
	}

	/**
	 * To be called when the size of this component is known
	 */
	public void initialize() {

		// Create StatConsole
		this.stats = new StatConsole(20, this.getHeight() - StatConsole.getHeight() - 20, this.avatar);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;

		// Paint tiles
		drawTiles(g2);

		// Paint children
		stats.paint(g2);
	}

	private void drawTiles(Graphics2D g2) {
		
		Location center = new Location(3,3);//avatar.getLocation();
		
		int radius = 4; // TODO: calculate viewable locations
		
		Map<Location, List<Locatable>> subMap = gameMap.getMapSubset(center, radius);		
		
		for ( Entry<Location,List<Locatable>> entry : subMap.entrySet()) {
			Location loc = entry.getKey();
			List<Locatable> locatables = entry.getValue();
			System.out.println(loc);
			
			BufferedImage tileImage = createTileImage(loc, locatables);
			addToTileCache(loc, tileImage);
		}
		
		// Draw everything in the cache on the screen (using getTileImage)
		// and black for the locations not in the cache
		// TODO
		
		
	}

	private BufferedImage createTileImage(Location loc, List<Locatable> locatables) {
		LocationDrawingVisitor v = new LocationDrawingVisitor();
		
		for (Locatable locatable : locatables) {
			locatable.accept(v);
		}
		
		return (BufferedImage) v.getImage();
		
	}
	
	private void addToTileCache(Location loc, BufferedImage img) {
		if (img != null && loc != null) {
			tileCache.put(loc, img);
		}
	}
	
	private BufferedImage getTileImage(Location loc) {
		BufferedImage ret = tileCache.get(loc);
		
		if (ret == null) {
			// Create and return a black image
			ret = new BufferedImage(60, 60, BufferedImage.TYPE_INT_RGB);	// TODO - i just made this line up
		}
		
		return ret;
	}
}