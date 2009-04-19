package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public class Fist extends Weapon {

	private static final long serialVersionUID = 6695844597752750894L;

	public Fist(Model model, Location loc, Character user) {
		super("Fist", model, loc, 10, PassiveSkill.BRAWLING, -1);
		setUser(user);
	}
}