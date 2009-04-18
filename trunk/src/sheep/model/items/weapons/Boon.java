package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class Boon extends Spell {

	private static final long serialVersionUID = 1743243793400230063L;

	public Boon(String id, Model model, Location loc, int baseDamage, int speed) {
		super(id, model, loc, baseDamage, PassiveSkill.BOON, speed);
	}	
}