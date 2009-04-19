package sheep.model.items.weapons.spells;

import sheep.model.Model;
import sheep.model.gamemap.Location;
import sheep.model.items.weapons.ProjectileWeapon;
import sheep.model.skills.PassiveSkill;

public abstract class Spell extends ProjectileWeapon {
	
	int mySpeed;

	private static final long serialVersionUID = -1606083256607931219L;
	
	public Spell(String id, Model model, Location loc, int baseDamage, PassiveSkill skill, int speed, int value) {
		super(id,id, model, loc, baseDamage, speed, skill, value);
		mySpeed = speed;
	}
}