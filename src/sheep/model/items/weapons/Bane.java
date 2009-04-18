package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class Bane extends Spell {

	private static final long serialVersionUID = -8870289527522592310L;

	public Bane(String id, Model model,  Location loc, int baseDamage, int speed) {
		super(id, model, loc, baseDamage, PassiveSkill.BANE, speed);
	}	
}