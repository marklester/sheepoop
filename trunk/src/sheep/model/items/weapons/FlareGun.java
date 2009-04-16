package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class FlareGun extends LongRange {

	private static final long serialVersionUID = 1857883205112292414L;
	
	public FlareGun(GameMap map, Location loc) {
		super("FlareGun", map, loc, 10);
	}

}