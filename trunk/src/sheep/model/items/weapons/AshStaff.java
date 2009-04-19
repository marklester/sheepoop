package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class AshStaff extends Staff {

	private static final long serialVersionUID = -2314195467271773528L;
	
	public AshStaff(Model model, Location loc) {
		super("Ash Staff", model, loc, 8, 10);
	}
}