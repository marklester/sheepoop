package sheep.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

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

	public AreaViewport(Avatar avatar, GameMap map) {
		this.gameMap = map;
		this.avatar = avatar;
	}
	
	/**
	 * To be called when the size of this component is known
	 */
	public void initialize() {
		
		// Create StatConsole
		this.stats = new StatConsole(20, this.getHeight() - StatConsole.getHeight() - 20, this.avatar);	
		
	}
	
	

	/**
	 * Location center = model.getAvatar().getLocation()
	 * int radius = // calculate viewable locations
	 * Map<Location, List<Locatable>> locatables = map.getSubMap(center, radius);
	 * for ( each location's locatables) {
	 *   BufferedImage tileImage = createTileImg(a location , a List<Locatable>)
	 *   addToTileCache(a Location, tileImage);
	 * }
	 * 
	 * now draw everything in the cache on the screen, and black for the locations not in the cache
	 */
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g);

		// Paint tiles
		
		// Paint children
		stats.paint(g2);
	}

	/**
	 * Image createImage(Location loc, List<Locatable> locatables) {
	 *   v = new LocationDrawingVisitor();
	 *   for each locatable, l {
	 *      l.accept(v);
	 *   }
	 *   return v.getImage();
	 * }
	 */
	private Image createTileImage(Location loc, List<Locatable> locatables) {
		throw new UnsupportedOperationException();
	}
}