package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class GoldStaff extends Staff {

	private static final long serialVersionUID = -2314195467271773528L;
	
	public GoldStaff(Model model, Location loc) {
		super("Gold Staff", model, loc, 11);
	}
}