package sheep.view;

import java.awt.Image;

import sheep.model.Decal;
import sheep.model.LocatableVisitor;
import sheep.model.areaeffects.AreaEffect;
import sheep.model.entities.Entity;
import sheep.model.entities.Vehicle;
import sheep.model.items.Item;
import sheep.model.terrains.Terrain;

public class LocationDrawingVisitor implements LocatableVisitor {

	public void visit(Item obj) {
		throw new UnsupportedOperationException();
	}

	public void visit(Vehicle obj) {
		throw new UnsupportedOperationException();
	}

	public void visit(Character obj) {
		throw new UnsupportedOperationException();
	}

	public void visit(Entity obj) {
		throw new UnsupportedOperationException();
	}

	public void visit(Terrain obj) {
		throw new UnsupportedOperationException();
	}

	public void visit(Decal obj) {
		throw new UnsupportedOperationException();
	}

	public void visit(AreaEffect obj) {
		throw new UnsupportedOperationException();
	}

	public Image getImage() {
		throw new UnsupportedOperationException();
	}
}