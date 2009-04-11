package sheep.view;

import sheep.model.Observer;
import sheep.model.StatChange;
import sheep.model.entities.Avatar;

public class StatConsole extends Overlay implements Observer<StatChange> {

	public StatConsole(Graphic2D g, Avatar avatar) {
		throw new UnsupportedOperationException();
	}

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(StatChange msg) {
		
	}
}