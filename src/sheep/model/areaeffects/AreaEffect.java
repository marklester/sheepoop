package sheep.model.areaeffects;

import sheep.model.Observer;
import sheep.model.TimeChange;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;

/**
 * 
 * @author Phil Freo
 */
public abstract class AreaEffect extends Locatable implements Observer<TimeChange> {
	
	private static final long serialVersionUID = 9171920339367314786L;
	
	public int rate;
	private Entity entity;

	public AreaEffect(String id, GameMap map, Location loc) {
		super(id, map, loc);
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}

	/**
	 * Cache the entity & call applyEffect
	 * @param the <code>Entity</code> that touches this AreaEffect
	 */
	public void touch(Entity entity) {
		this.entity = entity;
		applyEffect(entity);
	}

	public Entity getLastEntity() {
		return entity;
	}
	
	public abstract void applyEffect(Entity e);
	
	public abstract void update(TimeChange msg);
}