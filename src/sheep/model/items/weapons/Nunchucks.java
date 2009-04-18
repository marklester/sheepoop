package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class Nunchucks extends OneHanded {

	private static final long serialVersionUID = -5514383778390944563L;
	
	public Nunchucks(GameMap map, Location loc) {
		super("Nunchucks", map, loc, 8);
	}
	
}