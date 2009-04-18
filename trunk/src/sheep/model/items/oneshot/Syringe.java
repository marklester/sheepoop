package sheep.model.items.oneshot;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;

public class Syringe extends OneShot
{

	private static final long serialVersionUID = 1L;

	public Syringe(Model m, Location loc)
	{
		super("Syringe", m, loc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void touch(Entity entity)
	{
		entity.affectStat(StatType.AGILITY, 5);
		getGameMap().remove(getLocation(), this);
	}

}
