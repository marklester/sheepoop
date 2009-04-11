package sheep.view.overlays;

import java.awt.Graphics;

public abstract class Overlay {
	private int posX;
	private int posY;
	private int widthX;
	private int height;

	public Overlay(int posX, int posY) {
		this.posX = posX;
		this.posY = posX;
	}

	public boolean isVisible() {
		throw new UnsupportedOperationException();
	}

	public void draw(Graphics g) {
		throw new UnsupportedOperationException();
	}
}