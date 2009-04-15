package sheep.model.entities;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;
import sheep.model.items.Armor;
import sheep.model.items.Takeable;
import sheep.model.items.weapons.Weapon;
import sheep.model.occupations.Occupation;
import sheep.model.skills.PassiveSkill;
import sheep.model.skills.PerformableSkill;

public class Character extends Entity implements TalkMessageObservable, InventoryChangeObservable {

	private static final long serialVersionUID = 1069820547179793745L;
	
	private Inventory inventory;
	private Occupation occupation;
	private CharacterStats stats;
	private Weapon weapon;
	private Map<BodyPart, Armor> armor;
	private Map<PassiveSkill, Integer> passiveSkills;
	private List<PerformableSkill> performableSkills;
	private Character interactingCharacter;
	private Vector<TalkMessageObserver> talkObservers = new Vector<TalkMessageObserver>();
	private Vector<InventoryChangeObserver> inventoryObservers = new Vector<InventoryChangeObserver>();
	private Vector<StatChangeObserver> statChangeObservers = new Vector<StatChangeObserver>();
	
	public Character(String id, GameMap map, Location loc, Occupation occupation) {
		super(id, map, loc);
		this.occupation = occupation;
		this.performableSkills = occupation.clonePerformableSkills();
		this.stats = occupation.cloneStats();
		this.inventory = new Inventory();
		for (PerformableSkill ps : performableSkills)
			ps.setCharacter(this);		
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
		unequipWeapon();
		weapon = w;
	}

	public void equip(Armor a) {
		unequipArmor(a.getBodyPart());
		armor.put(a.getBodyPart(), a);
	}

	public void unequipWeapon() {
		if (weapon != null) 
			inventory.add(weapon);
		weapon = null;
	}

	public void unequipArmor(BodyPart fromWhere) {
		if (armor.get(fromWhere) != null)
			armor.put(fromWhere, null);
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
		return true;
	}

	public int getSpeed() {
		return stats.get(StatType.SPEED);
	}

	public void hearMessage(Character speaker, String msg) {
		throw new UnsupportedOperationException();
	}

	public Character getInteractingCharacter() {
		return this.interactingCharacter;
	}

	public void setInteractingCharacter(Character c) {
		this.interactingCharacter = c;
	}

	@Override
	public void notifyTalkMessageObservers(TalkMessage msg) {
		for (TalkMessageObserver observer : this.talkObservers) {
			observer.update(msg);
		}
	}

	@Override
	public void registerObserver(TalkMessageObserver observer) {
		if (!talkObservers.contains(observer)) {
			talkObservers.add(observer);
		}
	}

	@Override
	public void removeObserver(TalkMessageObserver observer) {
		talkObservers.remove(observer);
	}

	@Override
	public void notifyInventoryChangeObservers(InventoryChange msg) {
		for (InventoryChangeObserver observer : this.inventoryObservers) {
			observer.update(msg);
		}
	}

	@Override
	public void registerObserver(InventoryChangeObserver observer) {
		if (!inventoryObservers.contains(observer)) {
			inventoryObservers.add(observer);
		}
	}

	@Override
	public void removeObserver(InventoryChangeObserver observer) {
		inventoryObservers.remove(observer);
	}

	@Override
	public void notifyStatChangeObservers(StatChange msg) {
		for (StatChangeObserver observer : this.statChangeObservers) {
			observer.update(msg);
		}
	}

	@Override
	public void registerObserver(StatChangeObserver observer) {
		if (!statChangeObservers.contains(observer)) {
			statChangeObservers.add(observer);
		}
	}

	@Override
	public void removeObserver(StatChangeObserver observer) {
		statChangeObservers.remove(observer);
	}

	@Override
	public int getStat(StatType stat)
	{
		return stats.get(stat);
	}
	
	public CharacterStats getStats() {
		return this.stats;
	}
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
}