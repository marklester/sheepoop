package sheep.model.gamemap;

import java.io.Serializable;

/**
 * 
 * @author Phil Freo
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
}