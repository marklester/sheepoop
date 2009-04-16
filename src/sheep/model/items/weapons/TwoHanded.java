package sheep.model.items.weapons;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class TwoHanded extends Weapon {

	private static final long serialVersionUID = 6695844597752750894L;

	public TwoHanded(String id, GameMap map, Location loc) {
		super(id, map, loc, PassiveSkill.TWO_HANDED_WEAPON);
	}
}