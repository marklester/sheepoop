package sheep.model.items;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public abstract class Armor extends Takeable {
	
	private static final long serialVersionUID = 6475799713135184079L;

	public Armor(String id, GameMap map, Location loc) {
		super("Armor", map, loc);
	}

}