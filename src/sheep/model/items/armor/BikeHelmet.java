package sheep.model.items.armor;

import sheep.model.Model;
import sheep.model.entities.BodyPart;
import sheep.model.gamemap.Location;

public class BikeHelmet extends Armor
{
	private static final long serialVersionUID = 1L;

	public BikeHelmet(Model model, Location loc)
	{
		super("Bike Helmet", model, loc, BodyPart.HEAD, 10);
	}
}
