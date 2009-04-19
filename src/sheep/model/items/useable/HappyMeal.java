package sheep.model.items.useable;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;

public class HappyMeal extends Useable {

	public HappyMeal(Model model, Location loc) {
		super("Happy Meal", model, loc, 20);
	}
	
	@Override
	public void use(Character entity) {
		entity.removeItem(this);
		entity.affectStat(StatType.MANA_USED, 20);
		entity.affectStat(StatType.DAMAGE, 40);
		entity.affectStat(StatType.AGILITY, -9);
	}

}
