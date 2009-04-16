package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class Fire extends Bane {

	private static final long serialVersionUID = 2866354681809705242L;
	
	public Fire(GameMap map, Location loc) {
		super("Fire", map, loc, 20);
	}

}