package sheep.model.items.interactive;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;

public class PilotLicense extends Takeable
{

	private static final long serialVersionUID = 1L;

	public PilotLicense(Model model, Location loc)
	{
		super("Pilot License", model, loc, 5000);
	}

	@Override
	public void use(Character entity)
	{
		
	}
	
}
