package sheep.view.loading;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
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
		
		//Create the buttons
		SheepButton ngBtn = new SheepButton(newG_icon, new StartGameAction(this), btnDim);
		SheepButton lgBtn = new SheepButton(loadG_icon, new LoadGameAction(this), btnDim);
		btnPanel.add(ngBtn);
		btnPanel.add(lgBtn);
	}
	
	public void displayCharacterSelect() {	
		
		//Create the buttons
		ResourceLoader rl = ResourceLoader.getInstance();
		ImageIcon sm = new ImageIcon(rl.getImage("smasher")); 
		ImageIcon su = new ImageIcon(rl.getImage("summoner"));
		ImageIcon sn = new ImageIcon(rl.getImage("sneak"));
		Dimension icon_dim = new Dimension(sm.getIconWidth(), sm.getIconHeight());
		
		SheepButton smBtn = new SheepButton(sm, new CharacterSelectAction(this), icon_dim, "smasher");
		SheepButton suBtn = new SheepButton(su, new CharacterSelectAction(this), icon_dim, "summoner");
		SheepButton snBtn = new SheepButton(sn, new CharacterSelectAction(this), icon_dim, "sneak");
		
		//Create the panel & add buttons
		JPanel chrPanel = new JPanel(new FlowLayout());
		chrPanel.add(smBtn);
		chrPanel.add(suBtn);
		chrPanel.add(snBtn);
		
		//Locate the new panel over the intro buttons panel
		chrPanel.setPreferredSize(btnPanel.getPreferredSize());
		chrPanel.setLocale(btnPanel.getLocale());
		chrPanel.setOpaque(false);
		btnPanel.setVisible(false);
		
		this.getContentPane().add(chrPanel, BorderLayout.SOUTH);
		chrPanel.setVisible(true);
	}
	
	public void setCharacter(String res) {
		System.out.println(res);
	}
	
	
	
	
}

