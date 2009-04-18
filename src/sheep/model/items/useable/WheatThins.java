package sheep.model.items.useable;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;

public class WheatThins extends Useable
{
	private static final long serialVersionUID = 1L;

	public WheatThins(Model model, Location loc)
	{
		super("Wheat Thins", model, loc);
	}

	@Override
	public void use(Character entity)
	{
		entity.removeItem(this);
		entity.affectStat(StatType.DAMAGE, -25);
	}

}
