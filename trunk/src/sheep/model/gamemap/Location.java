package sheep.model.gamemap;

import java.io.Serializable;

import sheep.util.math.Vector2D;

/**
 * Represents a discrete location in 2D
 * @author Phil Freo
 * @author Bryan Rosander
 */
public class Location implements Serializable {
	private static final long serialVersionUID = -2038681527744934091L;

	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Location addVector(Vector2D vector) {
		Location ret = new Location(x, y);
		ret.x += vector.getX();
		ret.y += vector.getY();
		return ret;
	}

	public boolean equals(Object l2) {
		if (!(l2 instanceof Location)) {
			return false;
		}
		Location loc = (Location) l2;
		
		return ( (this.x == loc.x) && (this.y == loc.y) );
	}

	public int hashCode() {
		return (x * 1000 + y);
	}

	public String toString() {
		return "[Location x=" + x + ",y=" + y + "]";
	}
	/**
	 * This function returns the Direction the passed in location is relative to
	 * if location(10,3) is passed in and the this location is (10,2) then this will 
	 * return Direction.N
	 * @param l2 Location to get Direction relative to this one
	 * @return Direction
	 */
	public Direction relativeDirectionTo(Location l2){
		//even tiles
		if(getX()%2==0){//Even Columns
			if(l2.getY()<getY()){//Northern
				if(l2.getX()==getX())
					return Direction.N;
				if(l2.getX()<getX())
					return Direction.NW;
				if(l2.getX()>getX())
					return Direction.NE;
			}else{//Souther
				if(l2.getX()==getX())
					return Direction.S;
				if(l2.getX()<getX())
					return Direction.SW;
				if(l2.getX()>getX())
					return Direction.SE;
			}
		}else{//Odd Columns
			if(l2.getY()>getY()){//Southern
				if(l2.getX()==getX())
					return Direction.S;
				if(l2.getX()<getX())
					return Direction.SW;
				if(l2.getX()>getX())
					return Direction.SE;
			}else{//Northern
				if(l2.getX()==getX())
					return Direction.N;
				if(l2.getX()<getX())
					return Direction.NW;
				if(l2.getX()>getX())
					return Direction.NE;
			}	
		}
		return null;
	}
}