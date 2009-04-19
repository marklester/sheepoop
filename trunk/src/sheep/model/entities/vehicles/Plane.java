package sheep.model.entities.vehicles;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Location;
import sheep.model.items.interactive.PilotLicense;

public class Plane extends Vehicle
{

	private static final long serialVersionUID = 1L;
	
	private PilotLicense myLicense;

	public Plane(Model model, Location loc, PilotLicense myLicense)
	{
		super("Plane", model, loc, 27);
		this.myLicense = myLicense;
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
	@Override
	public boolean blocks(Entity entity) {		
		if (entity == getModel().getAvatar()) {
			return(!getModel().getAvatar().has(myLicense));
		}
		return true;
	}
}
