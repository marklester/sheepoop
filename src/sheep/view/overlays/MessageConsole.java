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

	private static final int width = 600;
	private static final int height = 100;
	private static final int MSGS_TO_SHOW = 8;
	private ArrayList<MessageWithTime> messages = new ArrayList<MessageWithTime>();
	

	public MessageConsole(int posX, int posY, Avatar avatar) {
		super(posX, posY);

		avatar.registerInventoryChangeObserver(this);
		avatar.registerStatChangeObserver(this);
		avatar.registerTalkMessageObserver(this);
	}

	@Override
	public void update(StatChange msg) {
		String str = msg.toString();
		messages.add(new MessageWithTime(str, 100));
	}

	@Override
	public void update(TalkMessage msg) {
		String str = msg.toString();
		messages.add(new MessageWithTime(str, 100));
	}

	@Override
	public void update(InventoryChange msg) {
		String str = msg.toString();
		messages.add(new MessageWithTime(str, 100));
	}

	@Override
	public void paint(Graphics2D g) {

		Font myFont = getFont().deriveFont(16f);
		g.setFont(myFont);

		// Draw background
		/*g.setColor(Color.BLACK);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f));
		g.fillRect(getPosX(), getPosY(), width, height);*/

		// Draw text
		g.setColor(Color.WHITE);
		int startIndex = messages.size() - 1;
		int endIndex = (messages.size() >= MSGS_TO_SHOW) ?  messages.size() - MSGS_TO_SHOW : 0;
		
		for (int i = startIndex; i >= endIndex; --i) {		
			drawMessage(g, messages.get(i).msg, startIndex - i, messages.get(i).freshness);
			
			// Decrement freshness
			if (messages.get(i).freshness > 0) {
				messages.get(i).freshness--;
			} else {
				messages.get(i).freshness = 0;
			}
			
		}
	}

	private void drawMessage(Graphics2D g, String msg, int orderOfNewness, int freshness) {
		float percentOpaque = freshness / 100f;
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
	
	private class MessageWithTime {
		private final String msg;
		private int freshness;
		
		private MessageWithTime(String msg, int freshness) {
			this.msg = msg;
			this.freshness = freshness;
		}
	}

}