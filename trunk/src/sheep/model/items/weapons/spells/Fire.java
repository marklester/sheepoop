package sheep.model.items.weapons.spells;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class Fire extends Bane {

	private static final long serialVersionUID = 2866354681809705242L;
	
	public Fire(Model model, Location loc) {
		super("Fire", model, loc, 20, 5);
	}

}