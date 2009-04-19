package sheep.view;

import javax.swing.JButton;

import sheep.controller.InteractionViewportListener;
import sheep.model.entities.Avatar;
import sheep.model.entities.Character;

public class InteractionViewport extends Viewport {

	private static final long serialVersionUID = 5416609943799230081L;

	private final Avatar avatar;
	private Character npc;
	
	private InteractionViewportListener actionListener;
	
	public InteractionViewport(Avatar avatar, Character npc) {
		super(avatar, 250, 100);
		this.avatar = avatar;
		this.npc = npc;
		
		JButton attackBtn = new JButton("Attack");
		this.add(attackBtn);

		JButton talkBtn = new JButton("Talk");
		this.add(talkBtn);
		
		JButton useItemBtn = new JButton("Use Item");
		this.add(useItemBtn);
		
		this.setBounds(0, 0, 300, 200);
		this.setOpaque(true);
		this.validate();
	}

	public void setActionListener(InteractionViewportListener al) {
		this.actionListener = al;
	}
}