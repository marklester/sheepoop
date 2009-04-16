package sheep.model.items.armor;

import sheep.model.entities.BodyPart;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class CrossTrainers extends Armor
{
	private static final long serialVersionUID = 1L;

	public CrossTrainers(GameMap map, Location loc)
	{
		super("Cross Trainers", map, loc, BodyPart.FEET, 10);
	}
}
