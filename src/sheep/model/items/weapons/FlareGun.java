package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class FlareGun extends LongRange {

	private static final long serialVersionUID = 1857883205112292414L;
	
	public FlareGun(Model model, Location loc) {
		super("flare","Flare Gun", model, loc, 10, 4, 20);
	}

}