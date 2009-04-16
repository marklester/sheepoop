package sheep.view.overlays;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import sheep.model.entities.Avatar;
import sheep.model.entities.InventoryChange;
import sheep.model.entities.InventoryChangeObserver;
import sheep.model.entities.StatChange;
import sheep.model.entities.StatChangeObserver;
import sheep.model.entities.TalkMessage;
import sheep.model.entities.TalkMessageObserver;

public class MessageConsole extends Overlay implements StatChangeObserver, TalkMessageObserver, InventoryChangeObserver {

	private static final int width = 400;
	private static final int height = 100;
	private Graphics2D g;
	

	public MessageConsole(int posX, int posY, Avatar avatar) {
		super(posX, posY);

		avatar.registerInventoryChangeObserver(this);
		avatar.registerStatChangeObserver(this);
		avatar.registerTalkMessageObserver(this);
		
	}

	@Override
	public void update(StatChange msg) {
	}

	@Override
	public void update(TalkMessage msg) {
		String str = msg.getMessage();
		//g.drawString(str, 0, 40);
	}

	@Override
	public void update(InventoryChange msg) {
	}

	@Override
	public void paint(Graphics2D g) {
		
		this.g = g;

		g.setColor(Color.BLACK);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f));
		g.fillRect(getPosX(), getPosY(), width, height);

		g.setColor(Color.WHITE);
		g.drawString("someone make a message console", getPosX() + 10, getPosY() + 20);

	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

}