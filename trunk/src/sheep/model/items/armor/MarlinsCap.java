package sheep.model.items.armor;

import sheep.model.Model;
import sheep.model.entities.BodyPart;
import sheep.model.gamemap.Location;

public class MarlinsCap extends Armor
{
	private static final long serialVersionUID = 1L;

	public MarlinsCap(Model model, Location loc)
	{
		super("Marlins Cap", model, loc, BodyPart.HEAD, 5);
	}
}
