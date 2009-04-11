package sheep.view;

import sheep.model.InventoryChange;
import sheep.model.Observer;
import sheep.model.StatChange;
import sheep.model.TalkMessage;
import sheep.model.entities.Avatar;

public class MessageConsole extends Overlay implements Observer<StatChange>, Observer<TalkMessage>, Observer<InventoryChange> {

	public MessageConsole(Graphic2D g, Avatar avatar) {
		throw new UnsupportedOperationException();
	}

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}
}