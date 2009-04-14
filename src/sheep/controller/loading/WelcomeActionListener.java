package sheep.controller.loading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.view.loading.WelcomeView;

/**
 * Load default key bindings (may be overridden by SettingsActionListener)
 */
public class WelcomeActionListener implements ActionListener {

	private WelcomeView welcomeview;
	
	public WelcomeActionListener( WelcomeView view ) {
		this.welcomeview = view;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String command = ae.getActionCommand();
		
		if( command.equals( WelcomeView.NEW_GAME ) ) {
			welcomeview.displayCharacterSelect();
		}
		else if( command.equals( WelcomeView.LOAD ) ) {
			
		}
	}
}