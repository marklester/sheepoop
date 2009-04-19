package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public class FistWeapon extends Weapon {

	private static final long serialVersionUID = -861392379425276075L;

	public FistWeapon( String id, Model model, Location loc, int baseDamage) {
		super(id, model, loc, baseDamage, PassiveSkill.BRAWLING, -1);
	}
	@Override
	public int getDamageWith()
	{
		return getBaseDamage() * getUser().getSkill(getSkill());
	}
}