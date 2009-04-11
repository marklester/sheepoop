package sheep.view.overlays;

import java.awt.Graphics;

import sheep.model.Observer;
import sheep.model.entities.Avatar;
import sheep.model.entities.StatChange;

public class StatConsole extends Overlay implements Observer<StatChange> {

	private Avatar avatar;
	
	public StatConsole(int posX, int posY, Graphics g, Avatar avatar) {
		super(posX, posY);
		this.avatar = avatar;
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(StatChange msg) {
		
	}
}