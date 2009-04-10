package model;

public abstract class Character extends model.Entity implements model.Observable, model.Observable {
	public model.Inventory inventory;
	public model.Occupation occupation;
	/**
	 * attack has direction stats, skill-rating, weapon current equipped
	 */
	public model.CharacterStats stats;
	public model.Weapon weapon;
	public Map<BodyPart, model.Armor> armor;
	public Map<model.PassiveSkill, int> passiveSkills;
	public List<model.PerformableSkill> performableSkills;
	model.Vehicle unnamed_Vehicle_;
	model.CharacterStats unnamed_CharacterStats_;
	model.PerformableSkill unnamed_PerformableSkill_;

	public Character(model.Occupation occupation) {
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

	public void equip(model.Weapon w) {
		throw new UnsupportedOperationException();
	}

	public void equip(model.Armor a) {
		throw new UnsupportedOperationException();
	}

	public void unequipWeapon() {
		throw new UnsupportedOperationException();
	}

	public void unequipArmor(model.BodyPart fromWhere) {
		throw new UnsupportedOperationException();
	}

	public void addToInventory(model.Takeable item) {
		throw new UnsupportedOperationException();
	}

	public void die() {
		throw new UnsupportedOperationException();
	}

	public void drop(model.Takeable item) {
		throw new UnsupportedOperationException();
	}

	public boolean removeItem(model.Takeable item) {
		throw new UnsupportedOperationException();
	}

	public void affectStat(model.StatType stat, int changeAmt) {
		throw new UnsupportedOperationException();
	}

	public boolean blocks(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	public int getSpeed() {
		throw new UnsupportedOperationException();
	}

	public void hearMessage(model.Character speaker, String msg) {
		throw new UnsupportedOperationException();
	}

	public model.Character getInteractingCharacter() {
		throw new UnsupportedOperationException();
	}

	public void setInteractingCharacter(model.Character c) {
		throw new UnsupportedOperationException();
	}
}