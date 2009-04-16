package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class Boon extends Spell {

	private static final long serialVersionUID = 1743243793400230063L;

	public Boon(String id, GameMap map, Location loc, int baseDamage) {
		super(id, map, loc, baseDamage, PassiveSkill.BOON);
	}	
}