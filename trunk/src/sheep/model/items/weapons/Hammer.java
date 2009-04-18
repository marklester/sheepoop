package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class Hammer extends OneHanded {

	private static final long serialVersionUID = -5514383778390944563L;
	
	public Hammer(Model m, Location loc) {
		super("Hammer", m, loc, 15);
	}
	
}