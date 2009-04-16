package sheep.model.items.armor;

import sheep.model.entities.BodyPart;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class SheepSandals extends Armor
{
	private static final long serialVersionUID = 1L;

	public SheepSandals(GameMap map, Location loc)
	{
		super("Sheep Sandals", map, loc, BodyPart.FEET, 5);
	}
}
