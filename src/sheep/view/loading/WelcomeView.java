package sheep.view.loading;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sheep.controller.actions.StartGameAction;
import util.ResourceLoader;


/*
 * 
 * Sorry, this is in the works... I need to transfer to my laptop...
 * 
 */


public class WelcomeView extends JFrame {

	private static final long serialVersionUID = 3905429913364344748L;
	private SettingsView settingsView;
	private JPanel bgPanel;
	private JPanel btnPanel;

	public WelcomeView() {
		setUpWindow();
		addButtons();
		this.setVisible(true);
	}
	
	private void setUpWindow() {
		this.setTitle("Sheepoop - Welcome Screen");
		final Image bg = ResourceLoader.getInstance().getBGImage();
		btnPanel = new JPanel(new FlowLayout());
		bgPanel = new JPanel()
		{
			public void paintComponent(Graphics g) {		
				Dimension d = getSize();
				g.drawImage(bg, 0, 0, (int)d.getWidth(), (int)d.getHeight(), null);
				super.paintComponents(g);
			}
		};
		bgPanel.setOpaque( false );
		this.add(bgPanel);
		//this.add(btnPanel);
		this.setSize( new Dimension(1000, 800) ); //We'll change this later... make it full screen.
		this.setLocationRelativeTo(null); // center
	}
	
	private void addButtons() {
		//Grab the resources
		ResourceLoader rl = ResourceLoader.getInstance();
		ImageIcon newG_icon = new ImageIcon(rl.getImage("newGame"));
		//ImageIcon loadG_icon = new ImageIcon(rl.getImage("loadGame"));
		//ImageIcon settings_icon = new ImageIcon(rl.getImage("settings"));
		//ImageIcon quitG_icon = new ImageIcon(rl.getImage("quitGame"));
		
		//Create the actions
		StartGameAction sga = new StartGameAction(newG_icon);		
		JButton but = new JButton(sga);
		
		
		
		//this.getContentPane().setLayout(new FlowLayout());
		btnPanel.add(but);
		
	}
	
	
}

