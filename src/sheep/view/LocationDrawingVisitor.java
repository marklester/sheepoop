package sheep.view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import sheep.model.areaeffects.AreaEffect;
import sheep.model.entities.Character;
import sheep.model.entities.Vehicle;
import sheep.model.gamemap.Decal;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.items.Item;
import sheep.model.terrains.Terrain;
import sheep.view.util.ResourceLoader;

public class LocationDrawingVisitor implements LocatableVisitor {

	private final int tileSize;
	private BufferedImage img;
	private Graphics2D g2;
	private BufferedImage terrain, character, vehicle, item, decal;
	private Vehicle vehicleObj;
	
	public LocationDrawingVisitor(int tileSize) {
		this.tileSize = tileSize;
		this.img = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB_PRE);
		this.g2 = img.createGraphics();
	}
	
	public void visit(Item obj) {
		item = (BufferedImage) ResourceLoader.getInstance().getImage(obj.getID());
	}

	public void visit(Vehicle obj) {
		vehicle = (BufferedImage) ResourceLoader.getInstance().getImage(obj.getID());
		
		this.vehicleObj = obj;
	}

	public void visit(Character obj) {
		character = (BufferedImage) ResourceLoader.getInstance().getImage(obj.getID());
	}

	public void visit(Terrain obj) {
		terrain = (BufferedImage) ResourceLoader.getInstance().getImage(obj.getID());
	}

	public void visit(Decal obj) {
		decal = (BufferedImage) ResourceLoader.getInstance().getImage(obj.getID());
	}

	public void visit(AreaEffect obj) {
		// not a visible thing
	}

	public Image getImage() {
		g2.drawImage(terrain, 0, 0, null);
		g2.drawImage(decal, 0, 0, null);
		g2.drawImage(item, 0, 0, null);
		
		// Rotate and draw vehicle
		if (vehicleObj != null) {
			double vehicleRotate = -1 * vehicleObj.getFacingDirection().getAngleInRadians();
			AffineTransform affineT = g2.getTransform(); 
			g2.rotate(vehicleRotate, img.getWidth() / 2, img.getHeight() / 2);
			g2.drawImage(vehicle, 0, 0, null);
			g2.setTransform(affineT);
		}
		
		g2.drawImage(character, 0, 0, null);
		return img;
	}
}