package sheep.view;

public abstract class Overlay {
	private int posX;
	private int posY;
	private int widthX;
	private int height;

	public Overlay(int posX, int posY) {
		throw new UnsupportedOperationException();
	}

	public boolean isVisible() {
		throw new UnsupportedOperationException();
	}

	public void draw(Object graphics_g) {
		throw new UnsupportedOperationException();
	}
}