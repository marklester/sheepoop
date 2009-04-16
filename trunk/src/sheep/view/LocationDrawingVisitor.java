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
import sheep.model.items.weapons.Projectile;
import sheep.model.terrains.Terrain;
import sheep.view.util.ResourceLoader;

public class LocationDrawingVisitor implements LocatableVisitor {

	private final int tileSize;
	private BufferedImage img;
	private Graphics2D g2;
	private BufferedImage terrain, character, vehicle, item, decal,projectile;
	private Vehicle vehicleObj;
	private Character characterObj;
	private Projectile projectileObj;
	
	public LocationDrawingVisitor(int tileSize) {
		this.tileSize = tileSize;
		this.img = new BufferedImage(this.tileSize, this.tileSize, BufferedImage.TYPE_INT_ARGB_PRE);
		this.g2 = img.createGraphics();
	}
	
	public void visit(Projectile obj)
	{
		projectile = (BufferedImage) ResourceLoader.getInstance().getImage(obj.getID());
		this.projectileObj = obj;
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
		this.characterObj = obj;
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
			AffineTransform affineT = g2.getTransform(); 
			double vehicleRotate = -1 * vehicleObj.getFacingDirection().getAngleInRadians();
			g2.rotate(vehicleRotate, img.getWidth() / 2, img.getHeight() / 2);
			g2.drawImage(vehicle, 0, 0, null);
			g2.setTransform(affineT);
		}
		
		if (characterObj != null && characterObj.getID() == "Wolf") {
			//AffineTransform affineT = g2.getTransform();
			//double rotate = (characterObj.getFacingDirection().getAngleInDegrees() <= 90) ? Math.PI / 2 : 0;
			//g2.rotate(rotate, img.getWidth() / 2, img.getHeight() / 2);
			g2.drawImage(character, 0, 0, null);
			//g2.setTransform(affineT);
		} else {
			g2.drawImage(character, 0, 0, null);
		}
		if (projectileObj != null) {
			AffineTransform affineT = g2.getTransform(); 
			double vehicleRotate = -1 * projectileObj.getFacingDirection().getAngleInRadians();
			g2.rotate(vehicleRotate, img.getWidth() / 2, img.getHeight() / 2);
			g2.drawImage(projectile, 0, 0, null);
			g2.setTransform(affineT);
		}
		return img;
	}
}