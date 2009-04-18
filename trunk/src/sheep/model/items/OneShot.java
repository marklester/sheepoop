package sheep.model.items;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public abstract class OneShot extends Item {

	public OneShot(String id, Model model, Location loc) {
		super(id, model, loc);
	}


	private static final long serialVersionUID = -2451877763558545713L;


	public abstract void touch(Entity entity);
	
}