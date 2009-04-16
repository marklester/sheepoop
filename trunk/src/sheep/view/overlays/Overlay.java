package sheep.view.overlays;

import java.awt.Font;
import java.awt.Graphics2D;

import sheep.view.util.ResourceLoader;

/**
 * 
 * @author Phil Freo
 */
public abstract class Overlay {
	
	private int posX;
	private int posY;
	private boolean isVisible = false;
	private Font font;

	public Overlay(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		isVisible = true;
		this.font = ResourceLoader.getInstance().getFont("statsFont");
	}

	public abstract void paint(Graphics2D g);
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public boolean isVisible() {
		return this.isVisible;
	}
	
	public void toggleVisibility() {
		isVisible = !isVisible;
	}
	
	public Font getFont() {
		return this.font;
	}
	
}