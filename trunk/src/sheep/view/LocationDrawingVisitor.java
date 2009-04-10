package view;

import model.Item;
import model.Character;
import model.Entity;
import model.Terrain;
import model.Decal;
import model.AreaEffect;
import model.LocatableVisitor;

public class LocationDrawingVisitor implements LocatableVisitor {
	view.AreaViewport unnamed_AreaViewport_;

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