package sheep.model.items.oneshot;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Location;

public class Key extends OneShot
{

	private static final long serialVersionUID = 1L;

	public Key(Model m, Location loc)
	{
		super("Key", m, loc);

	}

	@Override
	public void touch(Entity entity)
	{
		entity.setLocation(new Location(7, 13));
		getGameMap().remove(getLocation(), this);
	}

}