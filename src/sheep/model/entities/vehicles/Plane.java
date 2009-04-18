package sheep.model.entities.vehicles;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class Plane extends Vehicle
{

	private static final long serialVersionUID = 1L;

	public Plane(Model model, Location loc)
	{
		super("Plane", model, loc, 27);
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
