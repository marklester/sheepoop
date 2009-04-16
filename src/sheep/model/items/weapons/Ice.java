package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class Ice extends Bane {

	private static final long serialVersionUID = 7153412531505445049L;
	
	public Ice(GameMap map, Location loc) {
		super("Ice", map, loc);
	}

}