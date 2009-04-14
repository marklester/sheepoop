package sheep.view.loading;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import sheep.controller.loading.CharacterSelectionListener;
import sheep.controller.loading.WelcomeActionListener;
import util.ResourceLoader;


/*
 * 
 * Sorry, this is in the works... I need to transfer to my laptop...
 * 
 */


public class WelcomeView extends JFrame {

	private static final long serialVersionUID = 3905429913364344748L;
	
	public static final String NEW_GAME = "new game";
	public static final String LOAD = "load";
	
	public static final String SUMMONER = "summoner";
	public static final String SMASHER = "smasher";
	public static final String SNEAK = "sneak";
	
	private SettingsView settingsView;
	private JPanel bgPanel;
	private JPanel btnPanel;
	private CharacterSelectionListener charSelectionListener;
	private ActionListener welcomeListener;
	
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
		JButton ngBtn = new JButton(newG_icon);
		ngBtn.setPreferredSize(btnDim);
		ngBtn.setActionCommand( NEW_GAME );
		ngBtn.addActionListener( welcomeListener );
		
		JButton lgBtn = new JButton(loadG_icon);
		lgBtn.setPreferredSize(btnDim);
		lgBtn.setActionCommand( LOAD );
		lgBtn.addActionListener( welcomeListener );
		
		btnPanel.add(ngBtn);
		btnPanel.add(lgBtn);
	}
	
	public void displayCharacterSelect() {	
		
		//Create the buttons
		ResourceLoader rl = ResourceLoader.getInstance();
		ImageIcon sm = new ImageIcon(rl.getImage("smasher")); 
		ImageIcon su = new ImageIcon(rl.getImage("summoner"));
		ImageIcon sn = new ImageIcon(rl.getImage("sneak"));
		Dimension iconDim = new Dimension(sm.getIconWidth(), sm.getIconHeight());
		
		JButton smBtn = new JButton(sm);
		smBtn.setPreferredSize(iconDim);
		smBtn.setActionCommand( SMASHER );
		smBtn.addActionListener( charSelectionListener );
		
		JButton suBtn = new JButton(su);
		suBtn.setPreferredSize(iconDim);
		suBtn.setActionCommand( SUMMONER );
		suBtn.addActionListener( charSelectionListener );
		
		JButton snBtn = new JButton(sn);
		snBtn.setPreferredSize(iconDim);
		snBtn.setActionCommand( SNEAK );
		snBtn.addActionListener( charSelectionListener );
		
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
	
	public void setWelcomeActionListener( WelcomeActionListener listener )
	{
		this.welcomeListener = listener;
	}
	
	public void setWelcomeActionListener( CharacterSelectionListener listener )
	{
		this.charSelectionListener = listener;
	}
	
}