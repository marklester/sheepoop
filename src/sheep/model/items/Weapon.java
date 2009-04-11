package sheep.model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.model.entities.Entity;
import sheep.model.skills.PassiveSkill;

public abstract class Weapon extends Takeable implements ActionListener {
	
	public Weapon(String id) {
		super(id);
	}

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
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	
}