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
	public boolean equals(Location l2)
	{
		if((this.x==l2.x)&&(this.y==l2.y))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int hashCode()
	{
		return(x*1000+y);
	}
}