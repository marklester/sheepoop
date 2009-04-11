package sheep.model.entities;

import sheep.model.Observer;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;

public class Vehicle extends Entity {

	private static final long serialVersionUID = -7212987040280996071L;
	public Character occupant;
	public VehicleStatType stats;
	public Character driver;
	
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

	@Override
	public void notifyObservers() {
	}

	@Override
	public void registerObserver(Observer<StatChange> observer) {
	}

	@Override
	public void removeObserver(Observer<StatChange> observer) {
	}

}