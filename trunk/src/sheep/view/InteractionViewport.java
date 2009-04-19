package sheep.view;

import java.awt.Color;

import javax.swing.JButton;

import sheep.controller.InteractionViewportListener;
import sheep.model.entities.Avatar;
import sheep.model.entities.Character;

public class InteractionViewport extends Viewport {

	private static final long serialVersionUID = 5416609943799230081L;

	private InteractionViewportListener actionListener;
	
	private static int width = 400;
	private static int height = 50;
	private JButton attackBtn, talkBtn, useItemBtn, cancelBtn;
	
	public InteractionViewport(int x, int y) {
		super(null, width, height);

		this.setBackground(new Color(255, 255, 255, 100));
		attackBtn = new JButton("Attack");
		attackBtn.setActionCommand("attack");
		this.add(attackBtn);

		talkBtn = new JButton("Talk");
		talkBtn.setActionCommand("talk");
		this.add(talkBtn);
		
		useItemBtn = new JButton("Use Item");
		useItemBtn.setActionCommand("useItem");
		this.add(useItemBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setActionCommand("cancel");
		this.add(cancelBtn);
		
		this.setBounds(x - width / 2, y - height / 2, width, height);
		this.setOpaque(true);
		this.validate();
	}

	public void setActionListener(InteractionViewportListener al) {
		attackBtn.addActionListener(al);
		talkBtn.addActionListener(al);
		useItemBtn.addActionListener(al);
		cancelBtn.addActionListener(al);
	}
}