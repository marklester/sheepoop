package sheep.model.items.armor;

import sheep.model.entities.BodyPart;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class SteelToedShoes extends Armor
{
	private static final long serialVersionUID = 1L;

	public SteelToedShoes(GameMap map, Location loc)
	{
		super("Steel Toed Shoes", map, loc, BodyPart.FEET, 15);
	}
}
