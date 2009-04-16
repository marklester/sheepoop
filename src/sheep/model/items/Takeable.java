package sheep.model.items;

import sheep.model.entities.Character;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public abstract class Takeable extends Item {

	private static final long serialVersionUID = -7713416405052591178L;
	
	public Takeable(String id, GameMap map, Location loc) {
		super(id, map, loc);
	}

	public void touch(Entity entity) {
		
		// TODO - better way to handle this?
		// Jason: Why don't we just move inventory to Entity class, and a vehicle's addToInventory() will
		// just forward to the Avatar's inventory
		if (entity instanceof Character) {
			Character character = (Character) entity;
			character.addToInventory(this);
		}
	}

	public abstract void use(Character entity);

	public boolean blocks(Entity entity) {
		return false;
	}

}