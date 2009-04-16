package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class OneHanded extends Weapon {

	private static final long serialVersionUID = 5874280724912458146L;
	
	public OneHanded(String id, GameMap map, Location loc) {
		super(id, map, loc, PassiveSkill.ONE_HANDED_WEAPON);
	}

}