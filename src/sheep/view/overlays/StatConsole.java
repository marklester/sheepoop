package sheep.view.overlays;

import java.awt.Graphics2D;

import sheep.model.Observer;
import sheep.model.entities.Avatar;
import sheep.model.entities.StatChange;

public class StatConsole extends Overlay implements Observer<StatChange> {

	public StatConsole(int posX, int posY, Graphics2D g, Avatar avatar) {
		super(posX, posY);
		throw new UnsupportedOperationException();
	}

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(StatChange msg) {
		
	}
}