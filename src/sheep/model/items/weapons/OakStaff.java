package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class OakStaff extends Staff {

	private static final long serialVersionUID = -2314195467271773528L;
	
	public OakStaff(Model model, Location loc) {
		super("Oak Staff", model, loc, 10);
	}
}