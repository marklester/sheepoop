package sheep.model.entities.vehicles;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class Boat extends Vehicle
{

	private static final long serialVersionUID = -7616629418816528217L;

	public Boat(Model model, Location loc)
	{
		super("Boat", model, loc, 25);
	}

	@Override
	public boolean canClimb()
	{
		return false;
	}

	@Override
	public boolean canSwim()
	{
		return true;
	}

	@Override
	public boolean canWalk()
	{
		return false;
	}

}
