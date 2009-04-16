package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class Knife extends OneHanded {
	private static final long serialVersionUID = 7948706436194784002L;

	public Knife(GameMap map, Location loc) {
		super("Knife", map, loc, 10);
	}


}