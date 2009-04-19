package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class LongSword extends TwoHanded {

	private static final long serialVersionUID = -2314195467271773528L;
	
	public LongSword(Model model, Location loc) {
		super("Long Sword", model, loc, 35, 68);
	}
	
}