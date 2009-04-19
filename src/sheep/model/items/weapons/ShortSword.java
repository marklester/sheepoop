package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;


public class ShortSword extends OneHanded {

	private static final long serialVersionUID = -5514383778390944563L;
	
	public ShortSword(Model model, Location loc) {
		super("Short Sword", model, loc, 15, 50);
	}
	@Override
	public int getDamageWith()
	{
		return getBaseDamage() * getUser().getSkill(getSkill());
	}
}