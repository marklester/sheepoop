package sheep.model.items.oneshot;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;

public class Beer extends OneShot
{

	private static final long serialVersionUID = 1L;

	public Beer(Model m, Location loc)
	{
		super("Beer", m, loc);

	}

	@Override
	public void touch(Entity entity)
	{
		entity.affectStat(StatType.AGILITY, -3);
		entity.affectStat(StatType.HARDINESS, 5);
		entity.affectStat(StatType.STRENGTH, 2);
		entity.affectStat(StatType.INTELLECT, -3);
		getGameMap().remove(getLocation(), this);
	}

}