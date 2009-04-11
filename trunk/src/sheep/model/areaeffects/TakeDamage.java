package sheep.model.areaeffects;

import sheep.model.TimeChange;
import sheep.model.entities.Entity;

public class TakeDamage extends AreaEffect {

	private static final long serialVersionUID = -1922478825658683800L;

	public TakeDamage(String id) {
		super(id);
	}

	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	public void update(TimeChange msg) {
		throw new UnsupportedOperationException();
	}
}