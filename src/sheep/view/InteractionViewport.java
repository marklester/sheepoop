package sheep.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import sheep.controller.InteractionViewportListener;

public class InteractionViewport extends Viewport {

	private static final long serialVersionUID = 5416609943799230081L;

	private InteractionViewportListener actionListener;

	private static int width = 500;
	private static int height = 50;
	private JButton attackBtn, talkBtn, useItemBtn, cancelBtn, tradeBtn;

	public InteractionViewport(int x, int y) {
		super(null, width, height);

		this.setBackground(Color.BLUE);
		attackBtn = new JButton("Attack");
		attackBtn.setActionCommand("attack");
		this.add(attackBtn);

		talkBtn = new JButton("Talk");
		talkBtn.setActionCommand("talk");
		this.add(talkBtn);
		
		tradeBtn = new JButton("Trade");
		tradeBtn.setActionCommand("trade");
		this.add(tradeBtn);

		useItemBtn = new JButton("Use Item");
		useItemBtn.setActionCommand("useItem");
		this.add(useItemBtn);
		

		cancelBtn = new JButton("Cancel");
		cancelBtn.setActionCommand("cancel");
		this.add(cancelBtn);

		this.setBounds(x - width / 2, y - height / 2, width, height);
		this.setOpaque(false);
		this.validate();
	}
	
	/*
	public void paint(Graphics g) {
		super.paint(g);
		if (actionListener.useItemFlag)
			g.drawString("Choose an item from your inventory", 20, 20);
	}
	*/
	
	

	public void setActionListener(InteractionViewportListener al) {
		if (actionListener == null) {
			this.actionListener = al;
			attackBtn.addActionListener(al);
			talkBtn.addActionListener(al);
			useItemBtn.addActionListener(al);
			cancelBtn.addActionListener(al);
			tradeBtn.addActionListener(al);
		}
	}
}