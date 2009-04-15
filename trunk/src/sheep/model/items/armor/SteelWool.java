package sheep.model.items.armor;

import sheep.model.entities.BodyPart;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class SteelWool extends Armor
{
	private static final long serialVersionUID = 1L;

	public SteelWool(GameMap map, Location loc)
	{
		super("Steel Wool", map, loc, BodyPart.CHEST, 30);
	}
}
