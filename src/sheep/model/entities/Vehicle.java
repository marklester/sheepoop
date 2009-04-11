package sheep.model.entities;

import sheep.model.LocatableVisitor;
import sheep.model.Observer;

public class Vehicle extends Entity {
	public Character occupant;
	public VehicleStatType stats;
	public Character driver;

	public void accept(LocatableVisitor v) {
		throw new UnsupportedOperationException();
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

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}

	public void registerObserver(Observer<StatChange> observer) {
		throw new UnsupportedOperationException();
	}

	public void removeObserver(Observer<StatChange> observer) {
		throw new UnsupportedOperationException();
	}

	public void notifyObservers() {
		throw new UnsupportedOperationException();
	}
}