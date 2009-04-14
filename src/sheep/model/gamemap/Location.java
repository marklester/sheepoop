package sheep.model.gamemap;

import java.io.Serializable;

/**
 * 
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

	public boolean equals(Object l2) {
		if (!(l2 instanceof Location)) {
			return false;
		}
		Location loc = (Location) l2;
		
		if ((this.x == loc.x) && (this.y == loc.y)) {
			return true;
		} else {
			return false;
		}
	}

	
	
	public int hashCode() {
		return (x * 1000 + y);
	}

	public String toString() {
		return "[Location x=" + x + ",y=" + y + "]";
	}
}