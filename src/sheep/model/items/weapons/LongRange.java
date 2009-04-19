package sheep.model.items.weapons;

import sheep.model.Model;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;

public abstract class LongRange extends ProjectileWeapon {

	String projectileId;
	private static final long serialVersionUID = 6552089684638959608L;
	
	public LongRange(String projId, String id, Model model, Location loc,int speed, int baseDamage, int value) {
		super(projId, id, model, loc, baseDamage,speed, PassiveSkill.RANGED_WEAPON, value);
		projectileId = projId;
	}
}