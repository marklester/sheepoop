package sheep.model.areaeffects;

import sheep.model.TimeChange;
import sheep.model.entities.Entity;

public class River extends AreaEffect {

	private static final long serialVersionUID = -2338346084817804369L;

	public River(String id) {
		super(id);
	}

	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	public void update(TimeChange msg) {
		throw new UnsupportedOperationException();
	}
}