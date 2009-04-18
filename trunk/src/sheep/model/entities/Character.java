package sheep.model.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import sheep.model.CreepTimeObserver;
import sheep.model.Model;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;
import sheep.model.items.armor.Armor;
import sheep.model.items.weapons.Weapon;
import sheep.model.occupations.Occupation;
import sheep.model.skills.PassiveSkill;
import sheep.model.skills.PerformableSkill;

public abstract class Character extends Entity implements TalkMessageObservable, InventoryChangeObservable {

	private static final long serialVersionUID = 1069820547179793745L;

	private final Occupation occupation;
	private final Location startingLocation;
	private Inventory inventory;
	private CharacterStats stats;
	private Weapon weapon;
	private Map<BodyPart, Armor> armor;
	private Map<PassiveSkill, Integer> passiveSkills;
	private List<PerformableSkill> performableSkills;
	private Character interactingCharacter;
	private Vector<TalkMessageObserver> talkObservers = new Vector<TalkMessageObserver>();
	transient private Vector<TalkMessageObserver> transientTalkObservers = new Vector<TalkMessageObserver>();
	private Vector<InventoryChangeObserver> inventoryObservers = new Vector<InventoryChangeObserver>();
	transient private Vector<InventoryChangeObserver> transientInventoryObservers = new Vector<InventoryChangeObserver>();
	private Vector<StatChangeObserver> statChangeObservers = new Vector<StatChangeObserver>();
	transient private Vector<StatChangeObserver> transientStatChangeObservers = new Vector<StatChangeObserver>();
	private CreepTimeObserver creeptimer = new CreepTimeObserver(this);
	public Character(String id, Model model, Location loc, Occupation occupation) {
		super(id, model, loc);
		this.startingLocation = loc;
		this.occupation = occupation;
		this.performableSkills = occupation.clonePerformableSkills();
		this.stats = occupation.cloneStats();
		this.passiveSkills = occupation.clonePassiveSkills();
		this.inventory = new Inventory();
		this.armor = new HashMap<BodyPart,Armor>();
		for (PerformableSkill ps : performableSkills) {
			ps.setCharacter(this);
		}
		stats.setCharacter(this);
		stats.calculateDerivedStatistics();
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}
	
	public abstract void die();

	public void equip(Weapon w) {
		unequipWeapon();
		weapon = w;
		inventory.remove(w);
		this.notifyInventoryChangeObservers(new InventoryChange(w, InventoryChangeType.ITEM_EQUIPPED));
	}

	public void equip(Armor a) {
		unequipArmor(a.getBodyPart());
		armor.put(a.getBodyPart(), a);
		a.equipTo(this);
		inventory.remove(a);
		this.notifyInventoryChangeObservers(new InventoryChange(a, InventoryChangeType.ITEM_EQUIPPED));
	}

	public void unequipWeapon() {
		if (weapon != null) {
			inventory.add(weapon);
			weapon = null;
			this.notifyInventoryChangeObservers(new InventoryChange(weapon, InventoryChangeType.ITEM_UNEQUIPPED));
		}
		weapon = null;
	}

	public void unequipArmor(BodyPart fromWhere) {
		Armor piece = armor.get(fromWhere);
		if (piece != null) {
			armor.put(fromWhere, null);
			piece.unequipFrom(this);
			inventory.add(piece);
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
		
		// If a character tries to get off a boat, for example
		if (entity == this) {
			return false; 
		}
		
		// Necessary for NPCs to know when they are trying to move into a character
		if (entity instanceof Character) {
			((Character) entity).setInteractingCharacter(this);
		}
		
		// Block other entities from sharing a location
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
		for (TalkMessageObserver observer : this.transientTalkObservers) {
			observer.update(msg);
		}
	}

	@Override
	public void registerTalkMessageObserver(TalkMessageObserver observer) {
		if (!(observer instanceof Serializable)) {
			if (!transientTalkObservers.contains(observer)) {
				transientTalkObservers.add(observer);
			}
			return;
		}
		
		if (!talkObservers.contains(observer)) {
			talkObservers.add(observer);
		}
	}

	@Override
	public void removeTalkMessageObserver(TalkMessageObserver observer) {
		talkObservers.remove(observer);
		transientTalkObservers.remove(observer);
	}

	@Override
	public void notifyInventoryChangeObservers(InventoryChange msg) {
		for (InventoryChangeObserver observer : this.inventoryObservers) {
			observer.update(msg);
		}
		for (InventoryChangeObserver observer : this.transientInventoryObservers) {
			observer.update(msg);
		}
	}

	@Override
	public void registerInventoryChangeObserver(InventoryChangeObserver observer) {
		if (!(observer instanceof Serializable)) {
			if (!transientInventoryObservers.contains(observer)) {
				transientInventoryObservers.add(observer);
			}
			return;
		}
		
		if (!inventoryObservers.contains(observer)) {
			inventoryObservers.add(observer);
		}
	}

	@Override
	public void removeInventoryChangeObserver(InventoryChangeObserver observer) {
		transientInventoryObservers.remove(observer);
		inventoryObservers.remove(observer);
	}

	@Override
	public void notifyStatChangeObservers(StatChange msg) {
		for (StatChangeObserver observer : this.statChangeObservers) {
			observer.update(msg);
		}
		for (StatChangeObserver observer : this.transientStatChangeObservers) {
			observer.update(msg);
		}
	}

	@Override
	public void registerStatChangeObserver(StatChangeObserver observer) {
		if (!(observer instanceof Serializable)) {
			if (!transientStatChangeObservers.contains(observer)) {
				transientStatChangeObservers.add(observer);
			}
			return;
		}
		
		if (!statChangeObservers.contains(observer)) {
			statChangeObservers.add(observer);
		}
	}

	@Override
	public void removeStatChangeObserver(StatChangeObserver observer) {
		transientStatChangeObservers.remove(observer);
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
		Integer ret = passiveSkills.get(skill);
		if (ret == null) {
			return -1;
		}
		return ret;
	}

	public List<PerformableSkill> getPerformableSkills() {
		return this.performableSkills;
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
	
	public Location getStartingLocation() {
		return startingLocation;
	}

	public CreepTimeObserver getCreeptimer() {
		return creeptimer;
	}

}