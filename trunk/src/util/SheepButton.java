package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SheepButton extends JButton {

	public SheepButton(ImageIcon icon, ActionListener act) {
		super(icon);
		this.addActionListener(act);
		this.setOpaque(false);
		this.setBackground(Color.white);
	}
	
	public SheepButton(ImageIcon icon, ActionListener act, Dimension d) {
		this(icon, act);
		this.setPreferredSize(d);
	}
	
	public SheepButton(ImageIcon icon, ActionListener act, Dimension d, String cmd) {
		this(icon, act, d);
		this.setActionCommand(cmd);
	}
	
}
