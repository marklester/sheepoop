package sheep.model.areaeffects;

import sheep.model.Model;
import sheep.model.TimeObserver;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;

/**
 * 
 * @author Phil Freo
 */
public abstract class AreaEffect extends Locatable implements TimeObserver {
	
	private static final long serialVersionUID = 9171920339367314786L;
	
	public int rate;
	private Entity entity;

	public AreaEffect(String id, Model model, Location loc) {
		super(id, model, loc);
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}

	/**
	 * Cache the entity & call applyEffect
	 * @param the <code>Entity</code> that touches this AreaEffect
	 */
	public void touch(Entity entity) {
		if (entity == getModel().getMover()) {
			this.entity = entity;
			applyEffect(entity);
		}
	}

	public Entity getLastEntity() {
		return entity;
	}
	
	public abstract void applyEffect(Entity e);
	
	public abstract void tick();
}