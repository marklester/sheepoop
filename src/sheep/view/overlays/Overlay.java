package sheep.view.overlays;

import java.awt.Graphics2D;

/**
 * 
 * @author Phil Freo
 */
public abstract class Overlay {
	
	private int posX;
	private int posY;

	public Overlay(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public abstract void paint(Graphics2D g);
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
}