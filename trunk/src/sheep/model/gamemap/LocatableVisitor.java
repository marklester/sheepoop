package sheep.model.gamemap;

import sheep.model.areaeffects.AreaEffect;
import sheep.model.entities.Character;
import sheep.model.entities.Vehicle;
import sheep.model.items.Item;
import sheep.model.items.weapons.Projectile;
import sheep.model.terrains.Terrain;


/**
 * 
 * @author Phil Freo
 */
public interface LocatableVisitor {
	public void visit(Projectile obj);

	public void visit(Item obj);

	public void visit(Vehicle obj);

	public void visit(Character obj);

	public void visit(Terrain obj);

	public void visit(Decal obj);

	public void visit(AreaEffect obj);
}