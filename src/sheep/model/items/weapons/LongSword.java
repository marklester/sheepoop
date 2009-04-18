package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class LongSword extends TwoHanded {

	private static final long serialVersionUID = -2314195467271773528L;
	
	public LongSword(GameMap map, Location loc) {
		super("Long Sword", map, loc, 35);
	}
	
}