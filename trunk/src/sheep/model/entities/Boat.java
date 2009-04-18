package sheep.model.entities;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class Boat extends Vehicle
{

	public Boat(Model model, Location loc)
	{
		super("Boat", model, loc);
		// TODO Auto-generated constructor stub
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
		return true;
	}

}
