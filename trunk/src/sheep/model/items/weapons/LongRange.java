package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class LongRange extends Weapon {

	private static final long serialVersionUID = 6552089684638959608L;
	
	public LongRange(String id, GameMap map, Location loc, int baseDamage) {
		super(id, map, loc, baseDamage, PassiveSkill.RANGED_WEAPON);
	}

}