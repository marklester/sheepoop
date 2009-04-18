package sheep.model.terrains;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;

/**
 * 
 * @author Phil Freo
 */
public abstract class Terrain extends Locatable {

	public Terrain(String id, Model model, Location loc) {
		super(id, model, loc);
	}

	private static final long serialVersionUID = 7489043479583637533L;

	public void touch(Entity entity) {
	}

	public abstract boolean blocks(Entity entity);

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}
}