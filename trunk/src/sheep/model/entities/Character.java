package sheep.model.entities;

import java.util.List;
import java.util.Map;
import java.util.Vector;

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

	private Occupation occupation;
	private Inventory inventory;
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
		this.passiveSkills = occupation.clonePassiveSkills();
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
		// TODO
		throw new UnsupportedOperationException();
	}

	public int getRadiusOfVisibility() {
		return Math.max(1, 6 - getStat(StatType.MAX_LIFE) / getStat(StatType.LIFE));
	}

	public void die() {
		// TODO
	}
	
	public void equip(Weapon w) {
		unequipWeapon();
		weapon = w;
		this.notifyInventoryChangeObservers(new InventoryChange(w, InventoryChangeType.ITEM_EQUIPPED));
	}

	public void equip(Armor a) {
		unequipArmor(a.getBodyPart());
		armor.put(a.getBodyPart(), a);
		a.equipTo(this);
		this.notifyInventoryChangeObservers(new InventoryChange(a, InventoryChangeType.ITEM_EQUIPPED));
	}

	public void unequipWeapon() {
		if (weapon != null) {
			inventory.add(weapon);
			this.notifyInventoryChangeObservers(new InventoryChange(weapon, InventoryChangeType.ITEM_UNEQUIPPED));
		}
		weapon = null;
	}

	public void unequipArmor(BodyPart fromWhere) {
		Armor piece = armor.get(fromWhere);
		if (piece != null) {
			armor.put(fromWhere, null);
			piece.unequipFrom(this);
			this.notifyInventoryChangeObservers(new InventoryChange(piece, InventoryChangeType.ITEM_UNEQUIPPED));
		}
	}

	public void addToInventory(Takeable item) {
		this.inventory.add(item);
		this.notifyInventoryChangeObservers(new InventoryChange(item, InventoryChangeType.ITEM_ADDED));
	}

	public void drop(Takeable item) {
		this.removeItem(item);
		item.setLocation(this.getLocation());
	}

	public boolean removeItem(Takeable item) {
		return this.inventory.remove(item);
	}

	public void affectStat(StatType stat, int changeAmt) {
		this.stats.change(stat, changeAmt);
		this.notifyStatChangeObservers(new StatChange(stat, changeAmt));
	}

	public boolean blocks(Entity entity) {
		if (entity == this) {
			return false; // if a character tries to get off a boat, for example
		}
		return true;
	}

	public int getSpeed() {
		return stats.get(StatType.SPEED);
	}

	public void hearMessage(Character speaker, String msg) {
		this.notifyTalkMessageObservers(new TalkMessage(speaker, this, msg));
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
	public int getStat(StatType stat) {
		return stats.get(stat);
	}

	@Override
	public void weaponDamage(int damage) {
		affectStat(StatType.DAMAGE, damage);
	}

	@Override
	public void hitWith(Weapon w) {
		w.applyEffect(this);
	}

	public int getSkill(PassiveSkill skill) {
		return passiveSkills.get(skill);
	}

	public CharacterStats getStats() {
		return this.stats;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public Armor getEquipped(BodyPart bp) {
		return armor.get(bp);
	}

	public Weapon getEquippedWeapon() {
		return weapon;
	}

}