package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;

public class Knife extends OneHanded {
	private static final long serialVersionUID = 7948706436194784002L;

	public Knife(Model model, Location loc) {
		super("Knife", model, loc, 10);
	}


}