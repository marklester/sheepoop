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

	DrawInfo terrain, character, vehicle, item, decal,projectile;
	
	public LocationStringVisitor() {
	}
	
	public List<DrawInfo> getFullPicture()
	{
		ArrayList<DrawInfo> fullpic = new ArrayList<DrawInfo>();
		
		if(terrain!=null)
			fullpic.add(terrain);
		if(item!=null)
			fullpic.add(item);
		if(decal!=null)
			fullpic.add(decal);
		if(vehicle!=null)
			fullpic.add(vehicle);
		if(character!=null)
			fullpic.add(character);
		if(projectile!=null)
			fullpic.add(projectile);
		return(fullpic);
	}
	
	public void visit(Projectile obj)
	{
		projectile = new DrawInfo(obj.getID(),obj.getFacingDirection());
	}
	
	public void visit(Item obj) {
		item = new DrawInfo(obj.getID(),null);
	}

	public void visit(Vehicle obj) {
		vehicle = new DrawInfo(obj.getID(),obj.getFacingDirection());
	}

	public void visit(Character obj) {
		character = new DrawInfo(obj.getID(),obj.getFacingDirection());
	}

	public void visit(Terrain obj) {
		terrain = new DrawInfo(obj.getID(),null);
	}

	public void visit(Decal obj) {
		decal = new DrawInfo(obj.getID(),obj.getOrientation());
	}

	public void visit(AreaEffect obj) {
		// not a visible thing
	}
}
