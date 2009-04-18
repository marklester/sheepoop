package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;


public class ShortSword extends OneHanded {

	private static final long serialVersionUID = -5514383778390944563L;
	
	public ShortSword(GameMap map, Location loc) {
		super("Short Sword", map, loc, 15);
	}
	
}