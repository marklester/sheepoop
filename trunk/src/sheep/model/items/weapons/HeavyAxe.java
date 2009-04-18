package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class HeavyAxe extends TwoHanded {

	private static final long serialVersionUID = -2314195467271773528L;
	
	public HeavyAxe(GameMap map, Location loc) {
		super("Heavy Axe", map, loc, 30);
	}
	
}