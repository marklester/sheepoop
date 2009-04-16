package sheep.view.overlays;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

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
	private static final int MSGS_TO_SHOW = 4;
	private ArrayList<String> messages = new ArrayList<String>();

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
		messages.add(str);
	}

	@Override
	public void update(InventoryChange msg) {
	}

	@Override
	public void paint(Graphics2D g) {

		// Draw background
		Font myFont = getFont().deriveFont(16f);
		g.setFont(myFont);
		g.setColor(Color.BLACK);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f));
		g.fillRect(getPosX(), getPosY(), width, height);

		// Draw text
		g.setColor(Color.WHITE);
		int startIndex = messages.size() - 1;
		int endIndex = (messages.size() >= MSGS_TO_SHOW) ?  messages.size() - MSGS_TO_SHOW : 0;
		
		for (int i = startIndex; i >= endIndex; --i) {		
			drawMessage(g, messages.get(i), startIndex - i);
		}
	}

	private void drawMessage(Graphics2D g, String msg, int orderOfNewness) {
		float percentOpaque = 1 - orderOfNewness * 0.25f;
		if (percentOpaque < 0) {
			percentOpaque = 0;
		}
		Composite originalComposite = g.getComposite();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, percentOpaque));
		g.drawString(msg, getPosX() + 10, getPosY() + 20 + 20 * orderOfNewness);
		g.setComposite(originalComposite);
	}
	
	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

}