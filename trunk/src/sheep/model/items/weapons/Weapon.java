package sheep.model.items.weapons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;
import sheep.model.skills.PassiveSkill;

public abstract class Weapon extends Takeable implements ActionListener {
	
	private static final long serialVersionUID = -6972197855931649857L;
	private PassiveSkill skill;
	private Entity ent;
	
	public Weapon(String id, GameMap map, Location loc) {
		super(id, map, loc);
	}

	/**
	 * this should equip the weapon
	 */
	public void use(Entity ent) {
		this.ent = ent;
		ent.equip(this);
	}

	/**
	 * this should actually attack
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

	public PassiveSkill getSkill() {
		return this.skill;
	}
	
}