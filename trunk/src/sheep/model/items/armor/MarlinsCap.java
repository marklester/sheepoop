package sheep.model.items.armor;

import sheep.model.entities.BodyPart;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class MarlinsCap extends Armor
{
	private static final long serialVersionUID = 1L;

	public MarlinsCap(GameMap map, Location loc)
	{
		super("Marlins Cap", map, loc, BodyPart.HEAD, 5);
	}
}
