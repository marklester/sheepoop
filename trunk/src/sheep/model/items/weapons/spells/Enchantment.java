package sheep.model.items.weapons.spells;

import sheep.model.Model;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class Enchantment extends Spell {

	private static final long serialVersionUID = 5401072146663191171L;

	public Enchantment(String id, Model model, Location loc, int baseDamage, int speed, int value) {
		super(id, model, loc, baseDamage, PassiveSkill.ENCHANTMENT, speed, value);
	}	
	
}
