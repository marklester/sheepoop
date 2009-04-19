package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.entities.Avatar;
import sheep.model.entities.npc.NPC;

public class TalkAction extends AbstractAction {

	private static final long serialVersionUID = 6119775843258180224L;
	private final Avatar avatar;
	private final Character npc;

	public TalkAction(Avatar avatar, Character npc) {
		this.avatar = avatar;
		this.npc = npc;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("going to talk");
	}
}