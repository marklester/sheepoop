package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public abstract class Melee extends Weapon {

	private static final long serialVersionUID = 5874280724912458146L;
	
	public Melee(String id, GameMap map, Location loc) {
		super(id, map, loc);
	}

}