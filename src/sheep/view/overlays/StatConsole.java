package sheep.view.overlays;

import java.awt.Graphics;

import sheep.model.entities.Avatar;
import sheep.model.entities.StatChange;
import sheep.model.entities.StatChangeObserver;

public class StatConsole extends Overlay implements StatChangeObserver {

	private final Avatar avatar;
	
	public StatConsole(int posX, int posY, Graphics g, Avatar avatar) {
		super(posX, posY);
		this.avatar = avatar;


	}

	@Override
	public void update(StatChange msg) {
		
	}
}