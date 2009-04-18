package sheep.model.items.weapons.spells;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class Ice extends Bane {

	private static final long serialVersionUID = 7153412531505445049L;
	
	public Ice(Model model, Location loc) {
		super("Ice", model, loc, 10,8);
	}

}