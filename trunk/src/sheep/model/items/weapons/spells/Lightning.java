package sheep.model.items.weapons.spells;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class Lightning extends Bane {
	private static final long serialVersionUID = 5708249318652445L;

	public Lightning(Model model, Location loc) {
		super("Lightning", model, loc, 15,2,100);
	}


}