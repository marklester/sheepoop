package sheep.model.entities;

import java.util.List;
import java.util.Map;

import sheep.model.BodyPart;
import sheep.model.LocatableVisitor;
import sheep.model.Observable;
import sheep.model.Observer;
import sheep.model.TimeChange;
import sheep.model.items.Armor;
import sheep.model.items.Takeable;
import sheep.model.items.Weapon;
import sheep.model.occupations.Occupation;
import sheep.model.skills.PassiveSkill;
import sheep.model.skills.PerformableSkill;

public abstract class Character extends Entity implements Observable {
	private Inventory inventory;
	private Occupation occupation;
	/**
	 * attack has direction stats, skill-rating, weapon current equipped
	 */
	private CharacterStats stats;
	private Weapon weapon;
	private Map<BodyPart, Armor> armor;
	private Map<PassiveSkill, Integer> passiveSkills;
	private List<PerformableSkill> performableSkills;
	private Vehicle vehicle;
	private CharacterStats characterStats;
	private PerformableSkill performableSkill;

	public Character(String id, Occupation occupation) {
		super(id);
		this.occupation = occupation;
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}

	/**
	 * call weapon.perform(this)
	 */
	public void attack() {
		throw new UnsupportedOperationException();
	}

	public void equip(Weapon w) {
		throw new UnsupportedOperationException();
	}

	public void equip(Armor a) {
		throw new UnsupportedOperationException();
	}

	public void unequipWeapon() {
		throw new UnsupportedOperationException();
	}

	public void unequipArmor(BodyPart fromWhere) {
		throw new UnsupportedOperationException();
	}

	public void addToInventory(Takeable item) {
		throw new UnsupportedOperationException();
	}

	public void die() {
		throw new UnsupportedOperationException();
	}

	public void drop(Takeable item) {
		throw new UnsupportedOperationException();
	}

	public boolean removeItem(Takeable item) {
		throw new UnsupportedOperationException();
	}

	public void affectStat(StatType stat, int changeAmt) {
		throw new UnsupportedOperationException();
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public int getSpeed() {
		throw new UnsupportedOperationException();
	}

	public void hearMessage(Character speaker, String msg) {
		throw new UnsupportedOperationException();
	}

	public Character getInteractingCharacter() {
		throw new UnsupportedOperationException();
	}

	public void setInteractingCharacter(Character c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(TimeChange msg) {
	}

	public void notifyObservers() {
	}

	public void registerObserver(Observer<StatChange> observer) {
	}

	public void removeObserver(Observer<StatChange> observer) {
	}
	
}