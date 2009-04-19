package sheep.model.items.armor;

import sheep.model.Model;
import sheep.model.entities.BodyPart;
import sheep.model.gamemap.Location;

public class CrossTrainers extends Armor
{
	private static final long serialVersionUID = 1L;

	public CrossTrainers(Model model, Location loc)
	{
		super("Cross Trainers", model, loc, BodyPart.FEET, 10, 20);
	}
}
