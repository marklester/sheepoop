package sheep.model.entities;

import java.util.List;
import java.util.Map;

import sheep.model.Armor;
import sheep.model.BodyPart;
import sheep.model.CharacterStats;
import sheep.model.Inventory;
import sheep.model.InventoryChange;
import sheep.model.LocatableVisitor;
import sheep.model.Observable;
import sheep.model.Occupation;
import sheep.model.PassiveSkill;
import sheep.model.PerformableSkill;
import sheep.model.StatChange;
import sheep.model.StatType;
import sheep.model.items.Takeable;
import sheep.model.items.Weapon;

public abstract class Character extends Entity implements Observable<InventoryChange>, Observable<StatChange> {
	public Inventory inventory;
	public Occupation occupation;
	/**
	 * attack has direction stats, skill-rating, weapon current equipped
	 */
	public CharacterStats stats;
	public Weapon weapon;
	public Map<BodyPart, Armor> armor;
	public Map<PassiveSkill, Integer> passiveSkills;
	public List<PerformableSkill> performableSkills;
	Vehicle unnamed_Vehicle_;
	CharacterStats unnamed_CharacterStats_;
	PerformableSkill unnamed_PerformableSkill_;

	public Character(Occupation occupation) {
		throw new UnsupportedOperationException();
	}

	public void accept(LocatableVisitor v) {
		throw new UnsupportedOperationException();
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
}