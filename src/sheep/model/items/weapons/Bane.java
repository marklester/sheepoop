package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class Bane extends Spell {

	private static final long serialVersionUID = -8870289527522592310L;

	public Bane(String id, GameMap map, Location loc) {
		super(id, map, loc, PassiveSkill.BANE);
	}	
}