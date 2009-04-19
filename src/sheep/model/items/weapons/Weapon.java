package sheep.model.items.weapons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.Entity;
import sheep.model.entities.npc.NPC;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;
import sheep.model.skills.PassiveSkill;
import sheep.util.math.Vector2D;

public abstract class Weapon extends Takeable implements ActionListener {

	private static final long serialVersionUID = -6972197855931649857L;
	private PassiveSkill skill;
	private Character user;
	private int baseDamage;

	public Weapon(String id, Model model, Location loc, int baseDamage, PassiveSkill skill,int value){
		super(id, model, loc,value);
		this.skill = skill;
		this.baseDamage = baseDamage;
	}
	public Weapon(String id, Model model, Location loc){
		super(id, model, loc,0);
	}
	/**
	 * this should equip the weapon
	 */
	public void use(Character user) {
		if (user.getSkill(skill) >= 0) {
			this.user = user;
			user.equip(this);
		}
	}
	public abstract int getDamageWith();
	
	protected void setUser(Character user)
	{
		this.user = user;
	}
	public Character getUser() {
		return user;
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
		Vector2D myVector = user.getFacingDirection().getVector(user.getLocation());
		Location attackingTile = new Location(user.getLocation().getX() + (int) myVector.getX(), user.getLocation().getY()
				+ (int) myVector.getY());
		List<Locatable> targets = getGameMap().get(attackingTile);
		for (Locatable l : targets) {
			l.hitWith(this);
		}
	}

	public void applyEffect(Entity e) {
		e.weaponDamage(getDamageWith());
	}

	public void applyEffect(Character c) {
		c.weaponDamage(getDamageWith());
	}

	public void applyEffect(NPC npc)
	{
		npc.weaponDamage(getDamageWith());
	}
}