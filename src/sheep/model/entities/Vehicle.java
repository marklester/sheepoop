package sheep.model.entities;

import java.util.HashMap;
import java.util.Vector;

import sheep.model.Model;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;

public class Vehicle extends Entity {

	private static final long serialVersionUID = -7212987040280996071L;
	private final Model model;
	private HashMap<VehicleStatType, Integer> stats = new HashMap<VehicleStatType, Integer>();
	private Character driver;
	private Vector<StatChangeObserver> statChangeObservers = new Vector<StatChangeObserver>();

	public Vehicle(String id, GameMap map, Location loc, Model model) {
		super(id, map, loc);
		this.model = model;
		
		stats.put(VehicleStatType.SPEED, 10);	// TODO this may need to come from somewhere else
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}

	public boolean blocks(Entity entity) {
		if (entity instanceof Avatar) {
			return false;
		}
		return true;
	}

	public void affectStat(StatType stat, int changeAmt) {
		throw new UnsupportedOperationException();
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
		if (!(entity instanceof Character)) {
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
	
	/**
	 * Override setLocation from Locatable so we can move the driver's location
	 * as well (if we do in fact move)
	 */
	@Override
	public void setLocation(Location newLoc) {
		super.setLocation(newLoc);
		this.driver.setLocation(newLoc);
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
		if(driver == null)
		{
			return 0;
		}
		else
		{
			return driver.getStat(stat);
		}
	}

}