package model;

public interface LocatableVisitor {

	public void visit(model.Item obj);

	public void visit(Vehicle obj);

	public void visit(model.Character obj);

	public void visit(model.Vehicle obj);

	public void visit(model.Entity obj);

	public void visit(model.Terrain obj);

	public void visit(model.Decal obj);

	public void visit(model.AreaEffect obj);
}