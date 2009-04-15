package sheep.model.items.armor;

import sheep.model.entities.BodyPart;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class IronWool extends Armor
{
	private static final long serialVersionUID = 1L;

	public IronWool(GameMap map, Location loc)
	{
		super("Iron Wool", map, loc, BodyPart.CHEST, 20);
	}
}