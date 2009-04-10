package model;

public abstract class AreaEffect extends model.Locatable implements model.Observer {
	public int rate;
	private model.Entity entity;

	public abstract void applyEffect(model.Entity e);

	public void accept(LocatableVisitor v) {
		throw new UnsupportedOperationException();
	}

	public abstract void update(T msg);

	/**
	 * cache the entity & call applyEffect
	 */
	public void touch(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	public model.Entity getLastEntity() {
		throw new UnsupportedOperationException();
	}
}