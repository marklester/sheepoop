package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public class FistWeapon extends Weapon {

	private static final long serialVersionUID = -861392379425276075L;

	public FistWeapon( String id, GameMap map, Location loc) {
		super(id, map, loc, PassiveSkill.BRAWLING);
	}
}