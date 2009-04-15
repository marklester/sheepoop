package sheep.view;

import java.awt.Component;

import javax.swing.JPanel;

import sheep.controller.TradeButtonsActionListener;
import sheep.model.entities.Avatar;
import sheep.model.entities.npc.NPC;

public class TradeViewport extends Viewport {

	private static final long serialVersionUID = 3484298330273421838L;
	private NPC npc;
	
	public TradeViewport(Avatar avatar, NPC npc, int w, int h) {
		super(avatar, w, h);
		this.npc = npc;
		
	}

	public void setActionListener(TradeButtonsActionListener al) {
		throw new UnsupportedOperationException();
	}
}