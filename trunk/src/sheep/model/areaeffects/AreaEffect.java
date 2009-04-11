package sheep.model.areaeffects;

import sheep.model.Locatable;
import sheep.model.LocatableVisitor;
import sheep.model.Observer;
import sheep.model.TimeChange;
import sheep.model.entities.Entity;

public abstract class AreaEffect extends Locatable implements Observer<TimeChange> {
	
	public AreaEffect(String id) {
		super(id);
	}

	public int rate;
	private Entity entity;

	public abstract void applyEffect(Entity e);

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}

	public abstract void update(TimeChange msg);

	/**
	 * cache the entity & call applyEffect
	 */
	public void touch(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public Entity getLastEntity() {
		throw new UnsupportedOperationException();
	}
}