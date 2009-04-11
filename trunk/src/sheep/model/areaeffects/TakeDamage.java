package sheep.model.areaeffects;

import sheep.model.TimeChange;
import sheep.model.entities.Entity;

public class TakeDamage extends AreaEffect {

	public TakeDamage(String id) {
		super(id);
	}

	public void tick() {
		throw new UnsupportedOperationException();
	}

	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}

	public void update(TimeChange msg) {
		throw new UnsupportedOperationException();
	}
}