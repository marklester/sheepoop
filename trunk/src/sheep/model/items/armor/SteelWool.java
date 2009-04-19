package sheep.model.items.armor;

import sheep.model.Model;
import sheep.model.entities.BodyPart;
import sheep.model.gamemap.Location;

public class SteelWool extends Armor
{
	private static final long serialVersionUID = 1L;

	public SteelWool(Model model, Location loc)
	{
		super("Steel Wool", model, loc, BodyPart.CHEST, 30, 200);
	}
}
