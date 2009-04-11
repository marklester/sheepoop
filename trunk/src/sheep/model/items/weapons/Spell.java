package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;


public abstract class Spell extends Weapon {

	private static final long serialVersionUID = -1606083256607931219L;
	
	public Spell(String id, GameMap map, Location loc) {
		super(id, map, loc);
	}

}