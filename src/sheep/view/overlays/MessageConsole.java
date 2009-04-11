package sheep.view.overlays;

import java.awt.Graphics2D;

import sheep.model.Observer;
import sheep.model.entities.Avatar;
import sheep.model.entities.InventoryChange;
import sheep.model.entities.StatChange;
import sheep.model.entities.TalkMessage;

public class MessageConsole extends Overlay implements Observer<StatChange>, Observer<TalkMessage>, Observer<InventoryChange> {

	public MessageConsole(int posX, int posY, Graphics2D g, Avatar avatar) {
		super(posX, posY);
		throw new UnsupportedOperationException();
	}

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}
}