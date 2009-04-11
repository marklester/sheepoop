package sheep.view;

import java.awt.Component;

import sheep.controller.InteractionViewportListener;
import sheep.model.entities.Avatar;
import sheep.model.entities.NPC;

public class InteractionViewport extends Component {

	private static final long serialVersionUID = 5416609943799230081L;

	private Avatar avatar;
	private NPC npc;
	private InteractionViewportListener actionListener;
	
	public InteractionViewport(Avatar avatar, NPC npc) {
		this.avatar = avatar;
		this.npc = npc;
	}

	public void setActionListener(InteractionViewportListener al) {
		this.actionListener = al;
	}
}