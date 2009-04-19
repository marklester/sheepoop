package sheep.controller.loading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.KeyStroke;

import sheep.model.loading.KeySettings;
import sheep.model.loading.SettingsLoader;
import sheep.model.loading.SettingsSaver;
import sheep.view.loading.SettingsView;
import sheep.view.loading.WelcomeView;

public class SettingsActionListener implements ActionListener {
	
	private WelcomeView welcomeView;
	private SettingsView settingsView;

	public SettingsActionListener( WelcomeView wView, SettingsView sView ) {
		this.welcomeView = wView;
		this.settingsView = sView;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String command = ae.getActionCommand();
		
		if( command.equals( SettingsView.SETTINGS_CANCEL ) )
		{
			SettingsLoader loader = new SettingsLoader();
			settingsView.setKeySettings( loader.load() );
			welcomeView.displayMainView();
		}
		else if( command.equals( SettingsView.SETTINGS_OK ) )
		{
			SettingsSaver saver = new SettingsSaver();
			
			saver.save( settingsView.getKeySettings() );
			welcomeView.displayMainView();
		}
		else if( command.equals( SettingsView.SETTINGS_DEFAULT ) )
		{
			SettingsLoader loader = new SettingsLoader();
			settingsView.setKeySettings( loader.loadDefault() );
			
			if( SettingsLoader.CUSTOM_SETTINGS.exists() )
				SettingsLoader.CUSTOM_SETTINGS.delete();
		}
	}
}