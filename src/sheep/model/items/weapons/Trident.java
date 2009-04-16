package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;


public class Trident extends TwoHanded {

	private static final long serialVersionUID = -2314195467271773528L;
	
	public Trident(GameMap map, Location loc) {
		super("Trident", map, loc);
	}
	
}