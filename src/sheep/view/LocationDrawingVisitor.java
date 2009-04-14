package sheep.view;

import java.awt.Image;
import java.awt.image.BufferedImage;

import sheep.model.areaeffects.AreaEffect;
import sheep.model.entities.Entity;
import sheep.model.entities.Vehicle;
import sheep.model.gamemap.Decal;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.items.Item;
import sheep.model.terrains.Terrain;
import sheep.view.util.ResourceLoader;

public class LocationDrawingVisitor implements LocatableVisitor {

	private BufferedImage terrain;
	
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
		terrain = (BufferedImage) ResourceLoader.getInstance().getImage(obj.getID());
	}

	public void visit(Decal obj) {
		throw new UnsupportedOperationException();
	}

	public void visit(AreaEffect obj) {
		throw new UnsupportedOperationException();
	}

	public Image getImage() {
		return terrain;
	}
}