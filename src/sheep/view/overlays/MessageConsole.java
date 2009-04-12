package sheep.view.overlays;

import java.awt.Graphics2D;

import sheep.model.entities.Avatar;
import sheep.model.entities.InventoryChange;
import sheep.model.entities.InventoryChangeObserver;
import sheep.model.entities.StatChange;
import sheep.model.entities.StatChangeObserver;
import sheep.model.entities.TalkMessage;
import sheep.model.entities.TalkMessageObserver;

public class MessageConsole extends Overlay implements StatChangeObserver, TalkMessageObserver, InventoryChangeObserver {

	public MessageConsole(int posX, int posY, Graphics2D g, Avatar avatar) {
		super(posX, posY);
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(StatChange msg) {
	}

	@Override
	public void update(TalkMessage msg) {
	}

	@Override
	public void update(InventoryChange msg) {
	}

	
}