package sheep.view;

public abstract class Overlay {
	public int posX;
	public int posY;
	public int widthX;
	public int height;

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