package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;


public class SpearGun extends LongRange {

	private static final long serialVersionUID = 2843557941067998057L;
	
	public SpearGun(GameMap map, Location loc) {
		super("spear","Spear Gun", map, loc, 20);
	}
	
}