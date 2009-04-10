package model;

public abstract class Locatable {
	public model.Location loc;
	public model.GameMap map;
	model.GameMap unnamed_GameMap_;
	model.Location unnamed_Location_;

	public Locatable(String id) {
		throw new UnsupportedOperationException();
	}

	public abstract void accept(LocatableVisitor v);

	public void touch(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	public boolean blocks(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	public String getID() {
		throw new UnsupportedOperationException();
	}
}