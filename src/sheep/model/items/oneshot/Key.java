package sheep.model.items.oneshot;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Location;

public class Key extends OneShot
{

	Location myLoc;
	
	private static final long serialVersionUID = 1L;

	public Key(Model m, Location loc, Location destination)
	{
		super("Key", m, loc);
		myLoc = destination;
	}

	@Override
	public void touch(Entity entity)
	{
		entity.setLocation(myLoc);
		getGameMap().remove(getLocation(), this);
	}

}