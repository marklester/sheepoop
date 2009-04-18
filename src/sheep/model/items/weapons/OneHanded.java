package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class OneHanded extends Weapon {

	private static final long serialVersionUID = 5874280724912458146L;
	
	public OneHanded(String id, Model model, Location loc, int baseDamage) {
		super(id, model, loc, baseDamage, PassiveSkill.ONE_HANDED_WEAPON);
	}

}