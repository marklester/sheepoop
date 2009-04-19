package sheep.view;

import java.util.ArrayList;
import java.util.List;

import sheep.model.areaeffects.AreaEffect;
import sheep.model.entities.Character;
import sheep.model.entities.vehicles.Vehicle;
import sheep.model.gamemap.Decal;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.items.Item;
import sheep.model.items.weapons.Projectile;
import sheep.model.terrains.Terrain;
import sheep.view.util.DrawInfo;

public class LocationStringVisitor implements LocatableVisitor {

	List<DrawInfo> fullPicture;
	
	public LocationStringVisitor() {
		fullPicture = new ArrayList<DrawInfo>();
	}
	
	public List<DrawInfo> getFullPicture()
	{
		return fullPicture;
	}
	
	public void visit(Projectile obj)
	{
		fullPicture.add(new DrawInfo(obj.getID(),obj.getFacingDirection()));
	}
	
	public void visit(Item obj) {
		fullPicture.add(new DrawInfo(obj.getID(),null));
	}

	public void visit(Vehicle obj) {
		fullPicture.add(new DrawInfo(obj.getID(),obj.getFacingDirection()));
	}

	public void visit(Character obj) {
		fullPicture.add(new DrawInfo(obj.getID(),obj.getFacingDirection()));
	}

	public void visit(Terrain obj) {
		fullPicture.add(new DrawInfo(obj.getID(),null));
	}

	public void visit(Decal obj) {
		fullPicture.add(new DrawInfo(obj.getID(),null));
	}

	public void visit(AreaEffect obj) {
		// not a visible thing
	}
}
