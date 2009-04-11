package sheep.model.items;

import javax.swing.Action;

import sheep.model.entities.Entity;
import sheep.model.skills.PassiveSkill;

public abstract class Weapon extends Takeable implements Action {
	public PassiveSkill skill;

	/**
	 * this should equip the weapon
	 * entity.equip(this)
	 */
	public void use(Entity entity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * this should actually attack
	 */
	public abstract void actionPerformed();
}