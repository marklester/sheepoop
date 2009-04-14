package sheep.model.items;

import sheep.model.entities.BodyPart;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public abstract class Armor extends Takeable {
	
	private static final long serialVersionUID = 6475799713135184079L;
	private BodyPart where;
	
	public Armor(String id, GameMap map, Location loc, BodyPart bodyLocation) {
		super("Armor", map, loc);
		where = bodyLocation;
	}
	
	public BodyPart getBodyPart() {
		return this.where;
	}

}