package sheep.model.gamemap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

import sheep.util.math.Vector2D;

/**
 * 
 * @author Phil Freo
 */
public class GameMap implements Serializable {

	private static final long serialVersionUID = -6604540494991148223L;

	private HashMap<Location, Vector<Locatable>> map;

	public GameMap() {
		this.map = new HashMap<Location, Vector<Locatable>>();
	}

	public Vector<Locatable> get(Location loc) {
		Vector<Locatable> list = map.get(loc);
		if (list == null) {
			list = new Vector<Locatable>();
			map.put(loc, list);
		}
		return list;
	}

	public void add(Location loc, Locatable obj) {
		Vector<Locatable> locationList = get(loc);
		if (!locationList.contains(obj)) {
			locationList.add(obj);
		}
	}

	public boolean remove(Location loc, Locatable obj) {
		Vector<Locatable> list = map.get(loc);
		boolean result = list.remove(obj);
		return result;
	}

	public void notifyOfMovement(Location oldLoc, Location newLoc, Locatable obj) {
		// Remove Locatable from old Location
		Vector<Locatable> oldLocList = get(oldLoc);
		oldLocList.remove(obj);

		// Add it to new Location
		Vector<Locatable> newLocList = get(newLoc);
		if (!newLocList.contains(obj)) {
			newLocList.add(obj);
		}
	}

	public HashMap<Location, Vector<Locatable>> getMap() {
		return this.map;
	}
	
	public HashMap<Location, Vector<Locatable>> getMapSubset(Location origin, int radius) {
		int oX = origin.getX();
		int oY = origin.getY();
		HashMap<Location, Vector<Locatable>> mySubset = new HashMap<Location, Vector<Locatable>>();
		int apex = oY - radius;
		Location curLoc = new Location(oX,apex);
		for(int row = 0; row <= radius;row++)
		{
			int cols = row + 1;
			if(cols > radius +1)
			{
				cols = radius + 1;
			}
			Location tLoc = curLoc;
//			System.out.print("Opening Cone row " + (row+1) + ":");
			for(int col = 0; col < cols; col++)
			{
//				System.out.print("(" + tLoc.getX() + "," + tLoc.getY()+")   ");
				Vector<Locatable> curSpot = map.get(tLoc);
				if(curSpot!=null)
				{
//					System.out.print("Locatable found here!");
					mySubset.put(tLoc, curSpot);
				}
				tLoc = new Location(tLoc.getX()+2,tLoc.getY());
			}
//			System.out.println();
			Vector2D sw = Direction.SW.getVector(curLoc);
//			System.out.println("CurLoc.x = " + curLoc.getX() + "... Getting next first tile in row, Direction: ("+sw.getX()+","+sw.getY()+") ");
			curLoc = new Location(curLoc.getX()+(int)sw.getX(),curLoc.getY()+(int)sw.getY());
		}
		Vector2D ne = Direction.NE.getVector(curLoc);
		curLoc = new Location(curLoc.getX()+(int)ne.getX(),curLoc.getY()+(int)ne.getY());
		Vector2D se = Direction.SE.getVector(curLoc);
		curLoc = new Location(curLoc.getX()+(int)se.getX(),curLoc.getY()+(int)se.getY());
		for(int row = 0; row < radius; row++)
		{
			Location tLoc = curLoc;
//			System.out.print("Inner row " + (row+1) + ":");
			for(int col = 0; col < radius; col++)
			{
//				System.out.print("(" + tLoc.getX() + "," + tLoc.getY()+")   ");
				Vector<Locatable> curSpot = map.get(tLoc);
				if(curSpot!=null)
				{
//					System.out.print("Locatable found here!");
					mySubset.put(tLoc, curSpot);
				}
				tLoc = new Location(tLoc.getX()+2, tLoc.getY());
			}
//			System.out.print("\nOuter row " + (row+1)+":");
			Vector2D sw = Direction.SW.getVector(curLoc);
			curLoc = new Location(curLoc.getX()+(int)sw.getX(),curLoc.getY()+(int)sw.getY());
			tLoc = curLoc;
			for(int col = 0; col <= radius; col++)
			{
//				System.out.print("(" + tLoc.getX() + "," + tLoc.getY()+")   ");
				Vector<Locatable> curSpot = map.get(tLoc);
				if(curSpot!=null)
				{
//					System.out.print("Locatable found here!");
					mySubset.put(tLoc, curSpot);
				}
				tLoc = new Location(tLoc.getX()+2, tLoc.getY());
			}
//			System.out.println();
			Vector2D se2 = Direction.SE.getVector(curLoc);
			curLoc = new Location(curLoc.getX()+(int)se2.getX(),curLoc.getY()+(int)se2.getY());
		}
		for(int row = 0; row < radius; row++)
		{
			Location tLoc = curLoc;
//			System.out.print("Closing cone row "+row+":");
			for(int col = 0; col < (radius - row); col++)
			{
//				System.out.print("(" + tLoc.getX() + "," + tLoc.getY()+")   ");
				Vector<Locatable> curSpot = map.get(tLoc);
				if(curSpot!=null)
				{
//					System.out.print("Locatable found here!");
					mySubset.put(tLoc, curSpot);
				}
				tLoc = new Location(tLoc.getX()+2, tLoc.getY());
			}
//			System.out.println();
			Vector2D se2 = Direction.SE.getVector(curLoc);
			curLoc = new Location(curLoc.getX()+(int)se2.getX(),curLoc.getY()+(int)se2.getY());
		}
		return mySubset;
	}
}