package sheep.view.loading;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import sheep.controller.loading.SettingsActionListener;
import sheep.model.loading.KeySettings;
import sheep.view.util.ResourceLoader;

public class SettingsView extends JPanel {
	
	private static final long serialVersionUID = -6204291973851319584L;

	public static String SETTINGS_OK = "settings ok";
	public static String SETTINGS_DEFAULT = "settings default";
	public static String SETTINGS_CANCEL = "settings cancel";
	
	private SettingsActionListener settingsListener;
	
	private JButton defaultButton;
	private JButton cancelButton;
	private JButton okButton;
	
	private JTextField attack;
	private JTextField release;
	private JTextField north;
	private JTextField south;
	private JTextField northEast;
	private JTextField northWest;
	private JTextField southEast;
	private JTextField southWest;

	private KeySettings keySettings;
	
	public SettingsView( KeySettings keys ) {
		this.keySettings = keys;
		settingsListener = new SettingsActionListener();
		
		setUpPanel();
	}
	
	private void setUpPanel()
	{
		this.setLayout( new BorderLayout() );
		
		//button panel
		JPanel buttonPane = new JPanel();
		
		ResourceLoader rl = ResourceLoader.getInstance();
		ImageIcon okIcon = rl.getImageIcon( "OK" );
		ImageIcon defaultIcon = rl.getImageIcon( "Default" );
		ImageIcon cancelIcon = rl.getImageIcon( "Cancel" );
		Dimension iconDim = new Dimension( okIcon.getIconHeight(), okIcon.getIconWidth() );
		
		okButton = new JButton( okIcon );
		okButton.setPreferredSize( iconDim );
		okButton.setActionCommand( SETTINGS_OK );
		okButton.addActionListener( settingsListener );
		
		defaultButton = new JButton( defaultIcon );
		defaultButton.setPreferredSize( iconDim );
		defaultButton.setActionCommand( SETTINGS_DEFAULT );
		defaultButton.addActionListener( settingsListener );
		
		cancelButton = new JButton( cancelIcon );
		cancelButton.setPreferredSize( iconDim );
		cancelButton.setActionCommand( SETTINGS_CANCEL );
		cancelButton.addActionListener( settingsListener );
		
		buttonPane.add( okButton );
		buttonPane.add( cancelButton );
		buttonPane.add( defaultButton );
		
		//settings panel
		JPanel settings = new JPanel();
		settings.setLayout( new GridLayout(2, 3) );
		
		Map<String, KeyStroke> tempKeys = new HashMap<String,KeyStroke>();
		
		for( KeyStroke k : keySettings.getInputMap().allKeys() )
		{
			tempKeys.put( (String) keySettings.getInputMap().get(k) , k);
		}
		
		north = new JTextField( tempKeys.get( "moveN" ).getKeyChar() );
		northEast = new JTextField( tempKeys.get( "moveNE" ).getKeyChar() );
		northWest = new JTextField( tempKeys.get( "moveNW" ).getKeyChar() );
		south = new JTextField( tempKeys.get( "moveS" ).getKeyChar() );
		southEast = new JTextField( tempKeys.get( "moveSE" ).getKeyChar() );
		southWest = new JTextField( tempKeys.get( "moveSW" ).getKeyChar() );
		
		settings.add( northWest );
		settings.add( north );
		settings.add( northEast );
		settings.add( southWest );
		settings.add( south );
		settings.add( southEast );
		
		this.add( settings, BorderLayout.CENTER );
		this.add( buttonPane, BorderLayout.SOUTH );
	}
}