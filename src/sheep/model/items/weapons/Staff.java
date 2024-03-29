package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class Staff extends Weapon {

	private static final long serialVersionUID = 6695844597752750894L;

	public Staff(String id, Model model, Location loc, int baseDamage, int value) {
		super(id, model, loc, baseDamage, PassiveSkill.STAFF, value);
	}
}