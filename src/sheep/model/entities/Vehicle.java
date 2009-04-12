package sheep.model.entities;

import java.util.Vector;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;

public class Vehicle extends Entity {

	private static final long serialVersionUID = -7212987040280996071L;
	private VehicleStatType stats;
	private Character driver;
	private Vector<StatChangeObserver> statChangeObservers = new Vector<StatChangeObserver>();

	public Vehicle(String id, GameMap map, Location loc) {
		super(id, map, loc);
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public void affectStat(StatType stat, int changeAmt) {
		throw new UnsupportedOperationException();
	}

	public int getSpeed() {
		throw new UnsupportedOperationException();
	}

	public void touch(Entity entity) {
		throw new UnsupportedOperationException();
	}
	
	public Character getDriver() {
		return driver;
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

}