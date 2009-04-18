package sheep.model.items.weapons;

import java.awt.event.ActionEvent;
import java.util.List;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;
import sheep.util.math.Vector2D;

public abstract class LongRange extends ProjectileWeapon {

	String projectileId;
	private static final long serialVersionUID = 6552089684638959608L;
	
	public LongRange(String projId, String id, Model model, Location loc,int speed, int baseDamage) {
		super(projId, id, model, loc, baseDamage,speed, PassiveSkill.RANGED_WEAPON);
		projectileId = projId;
	}
}