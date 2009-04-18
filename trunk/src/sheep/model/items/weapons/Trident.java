package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;


public class Trident extends TwoHanded {

	private static final long serialVersionUID = -2314195467271773528L;
	
	public Trident(Model model, Location loc) {
		super("Trident", model, loc, 20);
	}
	
}