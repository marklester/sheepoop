package sheep.model.items.armor;

import sheep.model.entities.BodyPart;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;

public abstract class Armor extends Takeable {
	
	private static final long serialVersionUID = 6475799713135184079L;
	private BodyPart where;
	
	public Armor(String id, GameMap map, Location loc, BodyPart bodyLocation) {
		super("Armor", map, loc);
		where = bodyLocation;
	}
	
	public void use(Entity entity)
	{
		entity.equip(this);
	}
	
	public BodyPart getBodyPart() {
		return this.where;
	}

}