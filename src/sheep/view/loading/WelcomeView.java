package sheep.view.loading;

import javax.swing.JFrame;

public class WelcomeView extends JFrame {

	private static final long serialVersionUID = 3905429913364344748L;
	private SettingsView settingsView;

	public WelcomeView() {
		setUpWindow();
	}
	
	private void setUpWindow() {
		this.setTitle("sheepoop - welcome screen");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null); // center
		this.setVisible(true);
	}
}