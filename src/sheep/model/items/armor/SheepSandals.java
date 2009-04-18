package sheep.model.items.armor;

import sheep.model.Model;
import sheep.model.entities.BodyPart;
import sheep.model.gamemap.Location;

public class SheepSandals extends Armor
{
	private static final long serialVersionUID = 1L;

	public SheepSandals(Model model, Location loc)
	{
		super("Sheep Sandals", model, loc, BodyPart.FEET, 5);
	}
}
