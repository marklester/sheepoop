package sheep.model.gamemap;

import java.io.Serializable;

import sheep.util.math.Vector2D;

/**
 * 
 * @author Phil Freo
 * @author Bryan Rosander
 */

public enum Direction implements Serializable {
	N(90, new Vector2D(0, -1), new Vector2D(0,-1)), 
	NE(30, new Vector2D(1, 0), new Vector2D(1, -1)), 
	SE(330, new Vector2D(1,1), new Vector2D(1,0)), 
	S(270, new Vector2D(0, 1), new Vector2D(0,1)), 
	SW(210, new Vector2D(-1, 1), new Vector2D(-1,0)),
	NW(150, new Vector2D(-1, 0), new Vector2D(-1,-1));

	private int angle;
	private Vector2D oddVector;
	private Vector2D evenVector;

	Direction(int angle, Vector2D oddVec,Vector2D evenVec) {
		this.angle = angle;
		this.oddVector = oddVec;
		this.evenVector = evenVec;
	}

	/**
	 * Returns the angle of the direction, in degree, where N=90
	 * @return
	 */
	public int getAngleInDegrees() {
		return angle;
	}

	public double getAngleInRadians() {
		return getAngleInDegrees() * Math.PI / 180;
	}

	public Vector2D getVector(Location startingLoc) {
		int x = startingLoc.getX();
		if (Math.abs(x) % 2 == 1) {
			return oddVector;
		} else {
			return evenVector;
		}
	}
	public Direction opposite()
	{
		switch(this)
		{
		case N:
			return(S);
		case S:
			return(N);
		case NW:
			return(SE);
		case NE:
			return(SW);
		case SE:
			return(NW);
		case SW:
			return(NE);
		default:
			System.out.println("[Direction.java] MAJOR PROBLEM!!");
		}
		return null;
	}
	@Override
	public String toString()
	{
		String s = "";
		s+= getAngleInDegrees();
		return s;
	}
}
