package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class HeavyAxe extends TwoHanded {

	private static final long serialVersionUID = -2314195467271773528L;
	
	public HeavyAxe(Model model, Location loc) {
		super("Heavy Axe", model, loc, 30);
	}
	
}