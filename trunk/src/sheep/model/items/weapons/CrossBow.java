package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class CrossBow extends LongRange {

	private static final long serialVersionUID = -6449910210910592975L;
	
	public CrossBow(Model model, Location loc) {
		super("xbowbolt","Crossbow", model, loc, 15);
	}
}