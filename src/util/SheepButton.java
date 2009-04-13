package util;

import java.awt.Dimension;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SheepButton extends JButton {

	public SheepButton(ImageIcon icon, AbstractAction act) {
		super(icon);
		this.addActionListener(act);
	}
	
	public SheepButton(ImageIcon icon, AbstractAction act, Dimension d) {
		this(icon, act);
		this.setPreferredSize(d);
	}
	
}
