package sheep.model.gamemap;

import util.math.Vector2D;

/**
 * 
 * @author Phil Freo
 */
public enum Direction {
	N(new Vector2D(0, 1)), 
	NE(new Vector2D(1, 1)), 
	E(new Vector2D(0, 1)), 
	SE(new Vector2D(1, -1)), 
	S(new Vector2D(0, -1)), 
	SW(new Vector2D(-1, -1)),
	W(new Vector2D(-1, 0)),
	NW(new Vector2D(-1, 1));

	private Vector2D vector;

	Direction(Vector2D vec) {
		this.vector = vec;
	}

	public Vector2D getVector() {
		return vector;
	}
}
