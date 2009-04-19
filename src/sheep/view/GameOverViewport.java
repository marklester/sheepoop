package sheep.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sheep.view.util.ResourceLoader;

public class GameOverViewport extends JPanel {

	private static final long serialVersionUID = -140444731921350614L;
	
	public GameOverViewport(int w, int h) {
		
		this.setLayout(null);
		this.setBounds(0, 0, w, h);
		
		this.setBackground(Color.BLACK);
		
		Font font = ResourceLoader.getInstance().getFont("statsFont").deriveFont(48f);
		JLabel label = new JLabel("GAME OVER!!!");
		label.setForeground(Color.WHITE);
		label.setFont(font);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		
		this.add(label);
		this.setOpaque(true);
		this.validate();
	}
}
