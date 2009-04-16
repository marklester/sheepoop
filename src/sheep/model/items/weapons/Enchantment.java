package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class Enchantment extends Spell {

	private static final long serialVersionUID = 5401072146663191171L;

	public Enchantment(String id, GameMap map, Location loc, int baseDamage) {
		super(id, map, loc, baseDamage, PassiveSkill.ENCHANTMENT);
	}	
	
}
