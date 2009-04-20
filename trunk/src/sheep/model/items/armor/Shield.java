package sheep.model.items.armor;

import sheep.model.Model;
import sheep.model.entities.BodyPart;
import sheep.model.entities.Character;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public class Shield extends Armor
{
	private static final long serialVersionUID = 1L;

	public Shield(Model model, Location loc)
	{
		super("Shield", model, loc, BodyPart.AUX, 25, 100);
	}
	
	@Override
	public void use(Character entity)
	{
		entity.equip(this);
		PassiveSkill s = entity.getEquippedWeapon().getSkill();
		if((s==PassiveSkill.TWO_HANDED_WEAPON)||(s==PassiveSkill.RANGED_WEAPON))
		{
			entity.unequipWeapon();
		}
	}
}
