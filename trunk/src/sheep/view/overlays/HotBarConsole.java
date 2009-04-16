package sheep.view.overlays;

import java.awt.Graphics2D;

import sheep.model.entities.Avatar;

/**
 * Will be drawn on top of the AreaViewPort. 
 * Shows what things are bound to the hotkeys
 * Only allows performable skills
 */
public class HotBarConsole extends Overlay {

	private Avatar avatar;
	
	public HotBarConsole(int posX, int posY, Avatar avatar) {
		super(posX, posY);
		this.avatar = avatar;
	}

	@Override
	public void paint(Graphics2D g) {
	}

	
}