package sheep.model.items.armor;

import sheep.model.entities.BodyPart;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class Shield extends Armor
{
	private static final long serialVersionUID = 1L;

	public Shield(GameMap map, Location loc)
	{
		super("Shield", map, loc, BodyPart.FEET, 25);
	}
}
