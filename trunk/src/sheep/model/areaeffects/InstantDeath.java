package sheep.model.areaeffects;

import sheep.model.TimeChange;
import sheep.model.entities.Entity;

public class InstantDeath extends AreaEffect {

	private static final long serialVersionUID = 7991051797350750281L;

	public InstantDeath(String id) {
		super(id);
	}

	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	public void update(TimeChange msg) {
		throw new UnsupportedOperationException();
	}
}