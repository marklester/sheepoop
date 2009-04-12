package sheep.util.math;

import java.io.Serializable;

/**
 * 
 * @author Phil Freo
 */
public class Vector2D implements Serializable {
	private static final long serialVersionUID = 1398372928692423286L;
	private float x;
	private float y;

	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getMagnitude() {
		return (float) Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
	}
	
}