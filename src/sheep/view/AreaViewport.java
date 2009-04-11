package sheep.view;

import java.awt.Component;
import java.awt.Image;
import java.util.List;

import sheep.model.GameMap;
import sheep.model.Locatable;
import sheep.model.Location;
import sheep.model.entities.Avatar;

public class AreaViewport extends Component {
	private static final long serialVersionUID = 8296336314571261983L;
	
	LocationDrawingVisitor locationDrawingVisitor;

	public AreaViewport(Avatar avatar, GameMap map) {
		throw new UnsupportedOperationException();
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
	public void paint(Object graphics_g) {
		throw new UnsupportedOperationException();
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