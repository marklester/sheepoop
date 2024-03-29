package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.entities.BodyPart;
import sheep.model.entities.Character;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class TwoHanded extends Weapon {

	private static final long serialVersionUID = 6695844597752750894L;

	public TwoHanded(String id, Model model, Location loc, int baseDamage, int value) {
		super(id, model, loc, baseDamage, PassiveSkill.TWO_HANDED_WEAPON, value);
	}
	@Override
	public void use(Character user) {
		if (user.getSkill(getSkill()) >= 0) {
			setUser(user);
			user.equip(this);
			user.unequipArmor(BodyPart.AUX);
		}
	}
}