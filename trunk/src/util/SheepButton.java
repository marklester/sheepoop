package util;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SheepButton extends JButton {

	public SheepButton(ImageIcon icon, AbstractAction act) {
		super(icon);
		this.addActionListener(act);
		this.setOpaque(false);
		this.setBackground(Color.white);
	}
	
	public SheepButton(ImageIcon icon, AbstractAction act, Dimension d) {
		this(icon, act);
		this.setPreferredSize(d);
	}
	
}
