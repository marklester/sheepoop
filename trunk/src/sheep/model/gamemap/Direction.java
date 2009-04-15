package sheep.model.gamemap;

import sheep.util.math.Vector2D;

/**
 * 
 * @author Phil Freo
 * @author Bryan Rosander
 */

public enum Direction {
	N(new Vector2D(0, -1), new Vector2D(0,-1)), 
	NE(new Vector2D(1, 0), new Vector2D(1, -1)), 
	SE(new Vector2D(1,1), new Vector2D(1,0)), 
	S(new Vector2D(0, 1), new Vector2D(0,1)), 
	SW(new Vector2D(-1, 1), new Vector2D(-1,0)),
	NW(new Vector2D(-1, 0), new Vector2D(-1,-1));
	
	private Vector2D oddVector;
	private Vector2D evenVector;

	Direction(Vector2D oddVec,Vector2D evenVec) {
		this.oddVector = oddVec;
		this.evenVector = evenVec;
	}

	public Vector2D getVector(Location startingLoc) {
		int x = startingLoc.getX();
		if (Math.abs(x) % 2 == 1) {
			return oddVector;
		} else {
			return evenVector;
		}
	}
}
