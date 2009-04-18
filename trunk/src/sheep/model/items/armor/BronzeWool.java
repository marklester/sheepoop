package sheep.model.items.armor;

import sheep.model.Model;
import sheep.model.entities.BodyPart;
import sheep.model.gamemap.Location;

public class BronzeWool extends Armor
{
	private static final long serialVersionUID = 1L;

	public BronzeWool(Model model, Location loc)
	{
		super("Iron Wool", model, loc, BodyPart.CHEST, 10);
	}
}