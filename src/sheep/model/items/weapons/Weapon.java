package sheep.model.items.weapons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.model.entities.Character;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;
import sheep.model.skills.PassiveSkill;

public abstract class Weapon extends Takeable implements ActionListener {
	
	private static final long serialVersionUID = -6972197855931649857L;
	private PassiveSkill skill;
	private Character user;
	private int baseDamage;
	
	public Weapon(String id, GameMap map, Location loc, int baseDamage, PassiveSkill skill) {
		super(id, map, loc);
		this.skill = skill;
		this.baseDamage = baseDamage;
	}

	/**
	 * this should equip the weapon
	 */
	public void use(Character user) {
		this.user = user;
		user.equip(this);
	}

	public PassiveSkill getSkill() {
		return this.skill;
	}
	
	public int getBaseDamage() {
		return baseDamage;
	}

	/**
	 * this should actually attack
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		Character enemy = user.getInteractingCharacter();
		
		if( enemy != null )
		{
			int totalDamage = (int) Math.floor( (double) getBaseDamage() * (  (double) user.getSkill( getSkill() ) ) );
			
			enemy.affectStat( StatType.LIFE, totalDamage );
		}
	}
	public void applyEffect(Entity e)
	{
		e.weaponDamage(baseDamage* user.getSkill(skill));
	}
}