package sheep.model;

public enum Direction {
	N, NE, E, SE, S, SW, W, NW;
	
	Direction() {
		
	}
	
	public Vector2D getVector() {
		throw new UnsupportedOperationException();
	}
}
