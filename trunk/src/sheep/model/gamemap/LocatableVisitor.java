package sheep.model.gamemap;

import sheep.model.areaeffects.AreaEffect;
import sheep.model.entities.Entity;
import sheep.model.entities.Vehicle;
import sheep.model.items.Item;
import sheep.model.terrains.Terrain;

public interface LocatableVisitor {

	public void visit(Item obj);

	public void visit(Vehicle obj);

	public void visit(Character obj);

	public void visit(Entity obj);

	public void visit(Terrain obj);

	public void visit(Decal obj);

	public void visit(AreaEffect obj);
}