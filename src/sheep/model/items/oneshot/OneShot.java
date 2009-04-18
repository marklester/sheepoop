package sheep.model.items.oneshot;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.items.Item;

public abstract class OneShot extends Item {

	private static final long serialVersionUID = -2451877763558545713L;
	
	public OneShot(String id, Model m, Location loc) {
		super(id, m, loc);
	}

	public abstract void touch(Entity entity);
	
}