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

import sheep.controller.loading.NewGameAction;
import sheep.controller.loading.WelcomeActionListener;
import sheep.model.loading.SettingsLoader;
import sheep.view.util.ResourceLoader;

/**
 * Welcome window that lets a user start a new game or load existing
 * @author Jason McAninley
 */
public class WelcomeView extends JFrame {

	private static final long serialVersionUID = 3905429913364344748L;
	
	public static final String NEW_GAME = "new game";
	public static final String SETTINGS = "settings";
	public static final String LOAD = "load";
	public static final String SUMMONER = "summoner";
	public static final String SMASHER = "smasher";
	public static final String SNEAK = "sneak";
	
	private SettingsView settingsView;
	private JPanel bgPanel;
	private JPanel btnPanel;
	private NewGameAction newGameAction;
	private ActionListener welcomeListener;

	private JButton ngBtn;
	private JButton lgBtn;
	private JButton settingsBtn;
	
	private JButton smBtn;
	private JButton suBtn;
	private JButton snBtn;
	private Dimension scrDimension = new Dimension(800,600);
	private Dimension btnDim = new Dimension(150,100);

	private JPanel mainScreen;
	
	public WelcomeView() {
		welcomeListener = new WelcomeActionListener(this);
		newGameAction = new NewGameAction(this);
		
		SettingsLoader sl = new SettingsLoader();
		settingsView = new SettingsView( this, sl.load() );
//		settingsView.setOpaque( false );
		
		setUpPanels();
		addButtons();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(scrDimension); //We'll change this later... make it full screen.
		this.setResizable(false);
		this.setLocationRelativeTo(null); // center
	}
	
	private void setUpPanels() {
		
		this.setTitle("Sheepoop - Welcome Screen");
		final ImageIcon bg = ResourceLoader.getInstance().getImageIcon( "WelcomeScreenBG" );
		JLabel bgLabel = new JLabel(bg);
		bgLabel.setBounds(0, 0, (int)scrDimension.getWidth(), (int)scrDimension.getHeight());
		
		//Create panels
		bgPanel = new JPanel(null);  // this is passed null for a reason! Totally found that out the hard way. -Mike
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
		mainScreen = new JPanel( new BorderLayout() );
		mainScreen.setOpaque( false );
		mainScreen.add( btnPanel, BorderLayout.SOUTH );
		
		JLayeredPane layered = this.getLayeredPane();
		layered.add(bgPanel, new Integer (Integer.MIN_VALUE));

		this.setContentPane( mainScreen );
	}
	
	private void addButtons() {
		//Grab the resources
		ImageIcon newG_icon = ResourceLoader.getInstance().getImageIcon("newGame");
		ImageIcon loadG_icon = ResourceLoader.getInstance().getImageIcon("loadGame");
		ImageIcon settings_icon = ResourceLoader.getInstance().getImageIcon("settings");
		//ImageIcon quitG_icon = new ImageIcon(ResourceLoader.getInstance().getImage("quitGame"));
		
		//Create the buttons
		ngBtn = new JButton(newG_icon);
		ngBtn.setPreferredSize(btnDim);
		ngBtn.setActionCommand( NEW_GAME );
		ngBtn.addActionListener( welcomeListener );
		
		lgBtn = new JButton(loadG_icon);
		lgBtn.setPreferredSize(btnDim);
		lgBtn.setActionCommand( LOAD );
		lgBtn.addActionListener( welcomeListener );
		
		settingsBtn = new JButton(settings_icon);
		settingsBtn.setPreferredSize(btnDim);
		settingsBtn.setActionCommand( SETTINGS );
		settingsBtn.addActionListener( welcomeListener );
		
		btnPanel.add(ngBtn);
		btnPanel.add(lgBtn);
		btnPanel.add(settingsBtn);
	}
	
	public void displaySettingsView()
	{
		this.setContentPane( settingsView );
		this.validate();
	}
	
	public void displayMainView()
	{
		this.setContentPane( mainScreen );
		this.validate();
	}
	
	public void displayCharacterSelect() {	
		
		//Create the buttons
		ImageIcon sm = new ImageIcon(ResourceLoader.getInstance().getImage("smasherBtn")); 
		ImageIcon su = new ImageIcon(ResourceLoader.getInstance().getImage("summonerBtn"));
		ImageIcon sn = new ImageIcon(ResourceLoader.getInstance().getImage("sneakBtn"));
		Dimension iconDim = new Dimension(sm.getIconWidth(), sm.getIconHeight());
		
		smBtn = new JButton(sm);
		smBtn.setPreferredSize(iconDim);
		smBtn.setActionCommand( SMASHER );
		smBtn.addActionListener( newGameAction );
		
		suBtn = new JButton(su);
		suBtn.setPreferredSize(iconDim);
		suBtn.setActionCommand( SUMMONER );
		suBtn.addActionListener( newGameAction );
		
		snBtn = new JButton(sn);
		snBtn.setPreferredSize(iconDim);
		snBtn.setActionCommand( SNEAK );
		snBtn.addActionListener( newGameAction );
		
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
		
		mainScreen.add(chrPanel, BorderLayout.SOUTH);
		chrPanel.setVisible(true);
	}
}