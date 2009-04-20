package sheep.view.loading;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import sheep.controller.loading.SettingsActionListener;
import sheep.model.loading.KeySettings;
import sheep.view.util.KeyBindTextField;
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

	private KeyBindTextField attack;
	private KeyBindTextField release;
	private KeyBindTextField north;
	private KeyBindTextField south;
	private KeyBindTextField northEast;
	private KeyBindTextField northWest;
	private KeyBindTextField southEast;
	private KeyBindTextField southWest;

	private KeySettings keySettings;

	public SettingsView(WelcomeView view, KeySettings keys) {
		this.keySettings = keys;
		settingsListener = new SettingsActionListener(view, this);

		setUpPanel();
	}

	private void setUpPanel() {
		this.setLayout(new BorderLayout());

		// button panel
		JPanel buttonPane = new JPanel();
		buttonPane.setOpaque(false);

		ImageIcon okIcon = ResourceLoader.getInstance().getImageIcon("OK");
		ImageIcon defaultIcon = ResourceLoader.getInstance().getImageIcon("Default");
		ImageIcon cancelIcon = ResourceLoader.getInstance().getImageIcon("Cancel");
		Dimension iconDim = new Dimension(okIcon.getIconWidth(), okIcon.getIconHeight());

		okButton = new JButton(okIcon);
		okButton.setPreferredSize(iconDim);
		okButton.setActionCommand(SETTINGS_OK);
		okButton.addActionListener(settingsListener);
		okButton.setText("ok");

		defaultButton = new JButton(defaultIcon);
		defaultButton.setPreferredSize(iconDim);
		defaultButton.setActionCommand(SETTINGS_DEFAULT);
		defaultButton.addActionListener(settingsListener);
		defaultButton.setText("default");

		cancelButton = new JButton(cancelIcon);
		cancelButton.setPreferredSize(iconDim);
		cancelButton.setActionCommand(SETTINGS_CANCEL);
		cancelButton.addActionListener(settingsListener);
		cancelButton.setText("cancel");

		buttonPane.add(okButton);
		buttonPane.add(cancelButton);
		buttonPane.add(defaultButton);

		// settings panel
		JPanel settings = new JPanel();
		settings.setOpaque(false);
		settings.setLayout(new GridLayout(8, 1, 0, 20));

		north = new KeyBindTextField();
		northEast = new KeyBindTextField();
		northWest = new KeyBindTextField();
		south = new KeyBindTextField();
		southEast = new KeyBindTextField();
		southWest = new KeyBindTextField();
		attack = new KeyBindTextField();
		release = new KeyBindTextField();

		loadKeySettings();

		JTextField[] fields = { north, northEast, northWest, south, southEast, southWest, attack, release };
		JLabel[] labels = { new JLabel("North:"), new JLabel("North East:"), new JLabel("North West:"),
				new JLabel("South:"), new JLabel("South East:"), new JLabel("South West:"), new JLabel("Attack:"),
				new JLabel("Release Vehicle:") };

		layoutGrid(labels, fields, settings);
		// layoutFields(labels, fields, settings);
		this.add(Box.createRigidArea(new Dimension(100, 100)), BorderLayout.NORTH);
		this.add(Box.createRigidArea(new Dimension(100, 50)), BorderLayout.EAST);
		this.add(Box.createRigidArea(new Dimension(100, 50)), BorderLayout.WEST);
		this.add(settings, BorderLayout.CENTER);
		this.add(buttonPane, BorderLayout.SOUTH);

		this.setOpaque(false);
		validate();
	}

	public KeySettings getKeySettings() {
		KeySettings k = new KeySettings();
		k.put("moveN", north.getKeyStroke());
		k.put("moveNE", northEast.getKeyStroke());
		k.put("moveNW", northWest.getKeyStroke());
		k.put("moveS", south.getKeyStroke());
		k.put("moveSW", southWest.getKeyStroke());
		k.put("moveSE", southEast.getKeyStroke());
		k.put("useWeapon", attack.getKeyStroke());
		k.put("releaseVehicle", release.getKeyStroke());

		this.keySettings = k;
		loadKeySettings();

		return keySettings;
	}

	public void setKeySettings(KeySettings keySettings) {
		this.keySettings = keySettings;
		loadKeySettings();
	}

	private void loadKeySettings() {
		Map<String, KeyStroke> tempKeys = new HashMap<String, KeyStroke>();

		for (KeyStroke k : keySettings.getInputMap().allKeys()) {
			tempKeys.put((String) keySettings.getInputMap().get(k), k);
		}

		north.setKeyStroke(tempKeys.get("moveN"));
		northEast.setKeyStroke(tempKeys.get("moveNE"));
		northWest.setKeyStroke(tempKeys.get("moveNW"));
		south.setKeyStroke(tempKeys.get("moveS"));
		southEast.setKeyStroke(tempKeys.get("moveSE"));
		southWest.setKeyStroke(tempKeys.get("moveSW"));
		attack.setKeyStroke(tempKeys.get("useWeapon"));
		release.setKeyStroke(tempKeys.get("releaseVehicle"));
	}

	private void layoutGrid(JLabel[] labels, JTextField[] fields, Container container) {
		for (int i = 0; i < labels.length; i++) {
			// labels[i].setOpaque( false );
			container.add(labels[i]);
			container.add(fields[i]);
		}
	}
}