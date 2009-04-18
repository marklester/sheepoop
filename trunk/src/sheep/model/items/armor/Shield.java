package sheep.model.items.armor;

import sheep.model.Model;
import sheep.model.entities.BodyPart;
import sheep.model.gamemap.Location;

public class Shield extends Armor
{
	private static final long serialVersionUID = 1L;

	public Shield(Model model, Location loc)
	{
		super("Shield", model, loc, BodyPart.FEET, 25);
	}
}
