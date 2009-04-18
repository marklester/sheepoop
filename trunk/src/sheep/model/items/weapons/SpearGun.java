package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;


public class SpearGun extends LongRange {

	private static final long serialVersionUID = 2843557941067998057L;
	
	public SpearGun(Model model, Location loc) {
		super("spear","Spear Gun", model, loc, 20);
	}
	
}