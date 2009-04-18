package sheep.model.items;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Location;

public abstract class Interactive extends Item {

	private static final long serialVersionUID = 4777965387803747234L;
	
	public Interactive(String id, Model model, Location loc) {
		super(id, model, loc);
	}

	public void touch(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}
	
}