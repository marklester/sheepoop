package sheep.model.items.useable;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;

public class OrangeJuice extends Useable
{
	private static final long serialVersionUID = 1L;

	public OrangeJuice(Model model, Location loc)
	{
		super("Orange Juice", model, loc, 50);
	}

	@Override
	public void use(Character entity)
	{
		entity.removeItem(this);
		entity.affectStat(StatType.MANA_USED, -25);
	}

}
