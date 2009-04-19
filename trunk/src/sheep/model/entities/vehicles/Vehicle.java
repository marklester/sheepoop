package sheep.model.entities.vehicles;

import java.util.HashMap;
import java.util.Vector;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.Entity;
import sheep.model.entities.StatChange;
import sheep.model.entities.StatChangeObserver;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;
import sheep.model.items.armor.Armor;
import sheep.model.items.weapons.Weapon;

public abstract class Vehicle extends Entity {

	private static final long serialVersionUID = -7212987040280996071L;
	private final Model model;
	private HashMap<VehicleStatType, Integer> stats = new HashMap<VehicleStatType, Integer>();
	private Character driver;
	private Vector<StatChangeObserver> statChangeObservers = new Vector<StatChangeObserver>();
	
	public Vehicle(String id, Model model, Location loc, int speed) {
		super(id, model, loc);
		this.model = model;

		stats.put(VehicleStatType.SPEED, speed);
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}

	public boolean blocks(Entity entity) {		
		if (entity == model.getAvatar()) {
			return false;
		}
		return true;
	}

	public void affectStat(StatType stat, int changeAmt) {
		if (driver != null) {
			driver.affectStat(stat, changeAmt);
		}
	}

	public int getSpeed() {
		Integer ret = stats.get(VehicleStatType.SPEED);
		if (ret == null) {
			return 0;
		}
		return ret;
	}

	public void touch(Entity entity) {
		// Character gets in the vehicle
		
		if (entity != model.getAvatar()) {
			return;
		}

		entity.stopMoving();
		Character character = (Character) entity;

		this.model.setMover(this);

		this.driver = character;
	}

	public Character getDriver() {
		return driver;
	}

	public void clearDriver() {
		this.driver = null;
	}

	/**
	 * Override setLocation from Locatable so we can move the driver's location
	 * as well (if we do in fact move)
	 */
	@Override
	public void startMoving(Direction direction)
	{
		super.startMoving(direction);
		driver.setFacingDirection(direction);
	}
	@Override
	public void setLocation(Location newLoc) {
		super.setLocation(newLoc);
		if(driver!=null){
			this.driver.setLocation(newLoc);
		}
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
		if (driver == null) {
			return 0;
		} else {
			return driver.getStat(stat);
		}
	}

	@Override
	public void equip(Weapon w) {
		if (driver != null) {
			driver.equip(w);
		}
	}

	@Override
	public void equip(Armor a) {
		if (driver != null) {
			driver.equip(a);
		}
	}

	@Override
	public void weaponDamage(int amount) {
		// Do nothing, character will still get his
	}

}