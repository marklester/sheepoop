package sheep.model.items.armor;

import sheep.model.Model;
import sheep.model.entities.BodyPart;
import sheep.model.gamemap.Location;

public class SteelToedShoes extends Armor
{
	private static final long serialVersionUID = 1L;

	public SteelToedShoes(Model model, Location loc)
	{
		super("Steel Toed Shoes", model, loc, BodyPart.FEET, 15, 150);
	}
}
