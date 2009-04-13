package sheep.view.loading;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import sheep.controller.actions.*;
import util.ResourceLoader;
import util.SheepButton;


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
	private Dimension scrDimension = new Dimension(800,600);
	private Dimension btnDim = new Dimension(150,100);

	public WelcomeView() {
		setUpPanels();
		addButtons();
		this.setSize(scrDimension); //We'll change this later... make it full screen.
		this.setLocationRelativeTo(null); // center
		this.setVisible(true);
	}
	
	private void setUpPanels() {
		this.setTitle("Sheepoop - Welcome Screen");
		final ImageIcon bg = new ImageIcon(ResourceLoader.getInstance().getBGImage());
		JLabel bgLabel = new JLabel(bg);
		bgLabel.setBounds(0, 0, (int)scrDimension.getWidth(), (int)scrDimension.getHeight());
		
		//Create panels
		bgPanel = new JPanel(null);
		btnPanel = new JPanel(new FlowLayout());
		bgPanel.add(bgLabel);
		
		//Set properties of the panels
		bgPanel.setPreferredSize(scrDimension);
		bgPanel.setOpaque( false );
		bgPanel.setBounds(0, 0, (int)scrDimension.getWidth(), (int)scrDimension.getHeight());
		int yOff = (int)scrDimension.getHeight() - btnPanel.getHeight();
		btnPanel.setBounds(0, yOff, (int)scrDimension.getWidth(), (int)btnDim.getHeight());
		btnPanel.setOpaque(false);
		
		
		//Add to the JFrame and its panes
		JPanel content = (JPanel)this.getContentPane();
		content.setOpaque(false);
		content.add(btnPanel, BorderLayout.SOUTH);
		
		JLayeredPane layered = this.getLayeredPane();
		layered.add(bgPanel, new Integer (Integer.MIN_VALUE));

		
	}
	
	private void addButtons() {
		//Grab the resources
		ResourceLoader rl = ResourceLoader.getInstance();
		ImageIcon newG_icon = new ImageIcon(rl.getImage("newGame"));
		ImageIcon loadG_icon = new ImageIcon(rl.getImage("loadGame"));
		//ImageIcon settings_icon = new ImageIcon(rl.getImage("settings"));
		//ImageIcon quitG_icon = new ImageIcon(rl.getImage("quitGame"));
		
		//Create the actions
		StartGameAction nga = new StartGameAction();
		LoadGameAction lga = new LoadGameAction();
		
		//Create the buttons
		SheepButton ngBtn = new SheepButton(newG_icon, nga, btnDim);
		SheepButton lgBtn = new SheepButton(loadG_icon, lga, btnDim);
		
		//this.getContentPane().setLayout(new FlowLayout());
		btnPanel.add(ngBtn);
		btnPanel.add(lgBtn);
		
	}
	
	
}

