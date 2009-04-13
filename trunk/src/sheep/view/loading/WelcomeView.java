package sheep.view.loading;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import util.ResourceLoader;



public class WelcomeView extends JFrame {

	private static final long serialVersionUID = 3905429913364344748L;
	private SettingsView settingsView;

	public WelcomeView() {
		setUpWindow();
	}
	
	private void setUpWindow() {
		this.setTitle("Sheepoop - Welcome Screen");
		final Image bg = ResourceLoader.getInstance().getBGImage();
		JPanel jp = new JPanel()
		{
			public void paintComponent(Graphics g) {		
				Dimension d = getSize();
				g.drawImage(bg, 0, 0, (int)d.getWidth(), (int)d.getHeight(), null);
				super.paintComponents(g);
			}
		};
		jp.setOpaque( false );
		this.setSize( new Dimension(1000, 800) ); //We'll change this later... make it full screen.
		this.setLocationRelativeTo(null); // center
		this.add(jp);
		this.setVisible(true);

	}
}