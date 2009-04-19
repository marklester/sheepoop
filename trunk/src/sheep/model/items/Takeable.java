package sheep.model.items;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public abstract class Takeable extends Item {

	private static final long serialVersionUID = -7713416405052591178L;
	
	private int value;
	
	private final Model model;
	
	public Takeable(String id, Model model, Location loc, int value) {
		super(id, model, loc);
		this.model = model;
		this.value = value;
	}

	@Override
	public void touch(Entity entity) {
		
		if (entity == model.getAvatar()) {
			Character character = (Character) entity;
			character.addToInventory(this);
			GameMap theMap = getGameMap();
			theMap.remove(getLocation(), this);
		}
	}
	
	public int getPrice()
	{
		return value;
	}

	public abstract void use(Character entity);

	@Override
	public boolean blocks(Entity entity) {
		return false;
	}

}