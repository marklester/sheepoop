package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class CrossBow extends LongRange {

	private static final long serialVersionUID = -6449910210910592975L;
	
	public CrossBow(GameMap map, Location loc) {
		super("CrossBow", map, loc, 15);
	}

}