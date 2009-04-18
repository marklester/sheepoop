package sheep.view;

import sheep.controller.InteractionViewportListener;
import sheep.model.entities.Avatar;
import sheep.model.entities.npc.NPC;

public class InteractionViewport extends Viewport {

	private static final long serialVersionUID = 5416609943799230081L;

	private Avatar avatar;
	private NPC npc;
	private InteractionViewportListener actionListener;
	
	public InteractionViewport(Avatar avatar, NPC npc, int w, int h) {
		super(avatar, w, h);
		this.npc = npc;
	}

	public void setActionListener(InteractionViewportListener al) {
		this.actionListener = al;
	}
}