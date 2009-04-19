package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;


public class Nunchucks extends OneHanded {

	private static final long serialVersionUID = -5514383778390944563L;
	
	public Nunchucks(Model model, Location loc) {
		super("Nunchucks", model, loc, 8, 10);
	}
	
}