package sheep.model.entities;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import sheep.model.gamemap.Direction;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;
import sheep.model.items.armor.Armor;
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
		stats.calculateDerivedStatistics();
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
	
	public int getRadiusOfVisibility() {
		return 3; // TODO this must be based on items, stats, potions, etc.
	}

	public void equip(Weapon w) {
		unequipWeapon();
		weapon = w;
	}

	public void equip(Armor a) {
		unequipArmor(a.getBodyPart());
		armor.put(a.getBodyPart(), a);
		a.equipTo(this);
	}

	public void unequipWeapon() {
		if (weapon != null) 
			inventory.add(weapon);
		weapon = null;
	}

	public void unequipArmor(BodyPart fromWhere) {
		Armor piece = armor.get(fromWhere);
		if (piece != null)
		{
			armor.put(fromWhere, null);
			piece.unequipFrom(this);
		}
	}
	
	@Override
	public void setLocation(Location loc) {
		// TESTING ONLY just using this to get something to send to the talk message console
		super.setLocation(loc);
		
		this.notifyTalkMessageObservers(new TalkMessage(this, this, "Entity moved to " + loc));
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
		this.stats.change(stat, changeAmt);
	}

	public boolean blocks(Entity entity) {
		if (entity == this) {
			return false;	// if a character tries to get off a boat, for example
		}
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
	public void registerTalkMessageObserver(TalkMessageObserver observer) {
		if (!talkObservers.contains(observer)) {
			talkObservers.add(observer);
		}
	}

	@Override
	public void removeTalkMessageObserver(TalkMessageObserver observer) {
		talkObservers.remove(observer);
	}

	@Override
	public void notifyInventoryChangeObservers(InventoryChange msg) {
		for (InventoryChangeObserver observer : this.inventoryObservers) {
			observer.update(msg);
		}
	}

	@Override
	public void registerInventoryChangeObserver(InventoryChangeObserver observer) {
		if (!inventoryObservers.contains(observer)) {
			inventoryObservers.add(observer);
		}
	}

	@Override
	public void removeInventoryChangeObserver(InventoryChangeObserver observer) {
		inventoryObservers.remove(observer);
	}

	@Override
	public void notifyStatChangeObservers(StatChange msg) {
		for (StatChangeObserver observer : this.statChangeObservers) {
			observer.update(msg);
		}
	}

	@Override
	public void registerStatChangeObserver(StatChangeObserver observer) {
		if (!statChangeObservers.contains(observer)) {
			statChangeObservers.add(observer);
		}
	}

	@Override
	public void removeStatChangeObserver(StatChangeObserver observer) {
		statChangeObservers.remove(observer);
	}

	@Override
	public int getStat(StatType stat)
	{
		return stats.get(stat);
	}
	@Override
	public void weaponDamage(int damage)
	{
		affectStat(StatType.DAMAGE, damage);
	}
	
	public CharacterStats getStats() {
		return this.stats;
	}
	
	public Inventory getInventory() {
		return this.inventory;
	}

}