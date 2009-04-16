package sheep.model.items.armor;

import sheep.model.entities.BodyPart;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class BikeHelmet extends Armor
{
	private static final long serialVersionUID = 1L;

	public BikeHelmet(GameMap map, Location loc)
	{
		super("Bike Helmet", map, loc, BodyPart.HEAD, 10);
	}
}
