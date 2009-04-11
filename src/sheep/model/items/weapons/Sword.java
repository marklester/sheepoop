package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;


public class Sword extends Melee {

	private static final long serialVersionUID = -5514383778390944563L;
	
	public Sword(GameMap map, Location loc) {
		super("Sword", map, loc);
	}
	
}