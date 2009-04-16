package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class Lightening extends Bane {
	private static final long serialVersionUID = 5708249318652445L;

	public Lightening(GameMap map, Location loc) {
		super("Lightening", map, loc);
	}


}