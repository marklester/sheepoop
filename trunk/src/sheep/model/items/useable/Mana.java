package sheep.model.items.useable;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;

public class Mana extends Useable {

	public Mana(Model model, Location loc) {
		super("Mana", model, loc, 30);
	}


	@Override
	public void use(Character entity)
	{
		entity.removeItem(this);
		entity.affectStat(StatType.MANA_USED, -10);
	}


}
