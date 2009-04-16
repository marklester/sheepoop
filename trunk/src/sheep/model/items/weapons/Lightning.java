package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class Lightning extends Bane {
	private static final long serialVersionUID = 5708249318652445L;

	public Lightning(GameMap map, Location loc) {
		super("Lightning", map, loc, 15,2);
	}


}