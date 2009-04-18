package sheep.model.items;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Location;

/**
 * 
 * @author Phil Freo
 */
public class Obstacle extends Item {

	public Obstacle(String id, Model model, Location loc) {
		super(id, model, loc);
	}

	private static final long serialVersionUID = -3498178569028623819L;
	

	public boolean blocks(Entity entity) {
		return true;
	}
}