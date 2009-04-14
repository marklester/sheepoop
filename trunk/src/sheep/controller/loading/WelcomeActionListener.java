package sheep.controller.loading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.view.loading.WelcomeView;

/**
 * Creates the Model
 * Creates the View
 * Creates the Controller with the model & view
 * Load default key bindings (may be overridden by SettingsActionListener)
 */
public class WelcomeActionListener implements ActionListener {

	private WelcomeView view;
	
	public WelcomeActionListener( WelcomeView view ) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String command = ae.getActionCommand();
		
		if( command.equals( WelcomeView.NEW_GAME ) ) {
			view.displayCharacterSelect();
		}
		else if( command.equals( WelcomeView.LOAD ) ) {
			
		}
	}
}