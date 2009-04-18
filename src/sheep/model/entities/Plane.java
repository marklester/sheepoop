package sheep.model.entities;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class Plane extends Vehicle
{

	private static final long serialVersionUID = 1L;

	public Plane(Model model, Location loc)
	{
		super("Plane", model, loc);
	}

	@Override
	public boolean canClimb()
	{
		return true;
	}

	@Override
	public boolean canSwim()
	{
		return true;
	}

	@Override
	public boolean canWalk()
	{
		return true;
	}
	
}
