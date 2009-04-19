package sheep.model.entities;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;

import sheep.model.Model;
import sheep.model.NotSerializable;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;
import sheep.model.items.armor.Armor;
import sheep.model.items.weapons.Fist;
import sheep.model.items.weapons.Weapon;
import sheep.model.occupations.Occupation;
import sheep.model.skills.PassiveSkill;
import sheep.model.skills.PerformableSkill;

public abstract class Character extends Entity implements TalkMessageObservable, InventoryChangeObservable,
		SkillPointChangeObservable {

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

	private Vector<SkillPointChangeObserver> skillsObservers = new Vector<SkillPointChangeObserver>();
	transient private Vector<SkillPointChangeObserver> transientSkillsObservers = new Vector<SkillPointChangeObserver>();

	public Character(String id, Model model, Location loc, Occupation occupation) {
		super(id, model, loc);
		this.startingLocation = loc;
		this.occupation = occupation;
		this.performableSkills = occupation.clonePerformableSkills();
		this.stats = occupation.cloneStats();
		this.passiveSkills = occupation.clonePassiveSkills();
		this.inventory = new Inventory();
		this.armor = new HashMap<BodyPart, Armor>();
		for (PerformableSkill ps : performableSkills) {
			ps.setCharacter(this);
		}
		stats.setCharacter(this);
		stats.calculateDerivedStatistics();
	}

	public int getDamageWithWeapon()
	{
		Weapon w = getEquippedWeapon();
		if(w!=null)
		{
			return w.getDamageWith();
		}
		return 0;
	}
	
	public abstract boolean isDead();

	@Override
	public boolean canClimb() {
		return false;
	}

	@Override
	public boolean canSwim() {
		return false;
	}

	@Override
	public boolean canWalk() {
		return true;
	}

	public boolean has(Takeable item) {
		return inventory.has(item);
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
		this.notifyStatChangeObservers(new StatChange(StatType.OFFENSIVE_RATING,0));
	}

	public void equip(Armor a) {
		unequipArmor(a.getBodyPart());
		armor.put(a.getBodyPart(), a);
		a.equipTo(this);
		inventory.remove(a);
		this.notifyInventoryChangeObservers(new InventoryChange(a, InventoryChangeType.ITEM_EQUIPPED));
	}

	public void unequipWeapon() {
		Weapon theWeapon = weapon;
		if (weapon != null) {
			inventory.add(theWeapon);
			weapon = null;
			this.notifyInventoryChangeObservers(new InventoryChange(theWeapon, InventoryChangeType.ITEM_UNEQUIPPED));
		}
		this.notifyStatChangeObservers(new StatChange(StatType.OFFENSIVE_RATING,0));
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

	/**
	 * Adds an item to your inventory.  Returns whether or not the adding was
	 * successful (based on if the inventory is too full.)  This method does not 
	 * remove the item from the map.
	 * @param item
	 * @return 
	 */
	public boolean addToInventory(Takeable item) {
		if (this.inventory.getSize() >= 15) {
			return false;
		}
		this.inventory.add(item);
		this.notifyInventoryChangeObservers(new InventoryChange(item, InventoryChangeType.ITEM_ADDED));
		return true;
	}

	public void drop(Takeable item) {
		Takeable itemCpy = item;
		this.removeItem(item);
		itemCpy.setLocation(this.getLocation());
		this.notifyInventoryChangeObservers(new InventoryChange(itemCpy, InventoryChangeType.ITEM_DROPPED));
	}

	public boolean removeItem(Takeable item) {
		Takeable itemCpy = item;
		boolean result = this.inventory.remove(item);
		this.notifyInventoryChangeObservers(new InventoryChange(itemCpy, InventoryChangeType.ITEM_USED));
		return result;
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

		// Necessary for NPCs to know when they are trying to move into a
		// character
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
		this.notifyTalkMessageObservers(new TalkMessage(speaker, this, msg, false));
	}

	public void hearQuestion(Character speaker, String question) {
		this.notifyTalkMessageObservers(new TalkMessage(speaker, this, question, true));
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
		if (observer instanceof NotSerializable) {
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

		if (observer instanceof NotSerializable) {
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
		if (observer instanceof NotSerializable) {
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
	public void notifySkillPointObservers() {
		for (SkillPointChangeObserver observer : this.skillsObservers) {
			observer.update();
		}
		for (SkillPointChangeObserver observer : this.transientSkillsObservers) {
			observer.update();
		}
	}

	@Override
	public void registerSkillPointObserver(SkillPointChangeObserver observer) {
		if (observer instanceof NotSerializable) {
			if (!transientSkillsObservers.contains(observer)) {
				transientSkillsObservers.add(observer);
			}
			return;
		}

		if (!skillsObservers.contains(observer)) {
			skillsObservers.add(observer);
		}
	}

	@Override
	public void removeSkillPointObserver(SkillPointChangeObserver observer) {
		skillsObservers.remove(observer);
		transientSkillsObservers.remove(observer);
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
		// System.out.println(getID()+" was hit with "+w.getID());
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

	public Set<Entry<PassiveSkill, Integer>> getPassiveSkills() {
		return passiveSkills.entrySet();
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
		if((weapon==null)&&(getSkill(PassiveSkill.BRAWLING)>=0))
		{
			return(new Fist(getModel(), getLocation(), this));
		}
		return weapon;
	}

	public Location getStartingLocation() {
		return startingLocation;
	}

	public void addSkillPoint(PerformableSkill pSkill) {
		pSkill.addPoints(1);
		notifySkillPointObservers();
	}

	public void addSkillPoint(PassiveSkill pSkill) {
		Integer currValue = passiveSkills.get(pSkill);
		passiveSkills.put(pSkill, currValue + 1);
		notifySkillPointObservers();
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		transientTalkObservers = new Vector<TalkMessageObserver>();
		transientInventoryObservers = new Vector<InventoryChangeObserver>();
		transientStatChangeObservers = new Vector<StatChangeObserver>();
		transientSkillsObservers = new Vector<SkillPointChangeObserver>();
		ois.defaultReadObject();
	}
}