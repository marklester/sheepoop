package sheep.model.entities;

import sheep.model.LocatableVisitor;
import sheep.model.StatType;

public class Vehicle extends model.Entity {
	public model.Character occupant;
	public VehicleStats stats;
	public model.Character driver;

	public void accept(LocatableVisitor v) {
		throw new UnsupportedOperationException();
	}

	public boolean blocks(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	public void affectStat(StatType stat, int changeAmt) {
		throw new UnsupportedOperationException();
	}

	public int getSpeed() {
		throw new UnsupportedOperationException();
	}

	public void touch(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}

	public void registerObserver(model.Observer<T> observer) {
		throw new UnsupportedOperationException();
	}

	public void removeObserver(model.Observer<T> observer) {
		throw new UnsupportedOperationException();
	}

	public void notifyObservers() {
		throw new UnsupportedOperationException();
	}
}