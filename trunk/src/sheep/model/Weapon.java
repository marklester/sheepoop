package model;

public abstract class Weapon extends model.Takeable implements model.Action {
	public SkillType skill;

	/**
	 * this should equip the weapon
	 * entity.equip(this)
	 */
	public void use(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * this should actually attack
	 */
	public abstract void actionPerformed();
}