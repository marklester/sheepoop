package sheep;

import sheep.controller.loading.CharacterSelectionListener;
import sheep.controller.loading.WelcomeActionListener;
import sheep.view.loading.WelcomeView;

public class RunGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		WelcomeView view = new WelcomeView();
		view.setVisible( true );	
	}
}
