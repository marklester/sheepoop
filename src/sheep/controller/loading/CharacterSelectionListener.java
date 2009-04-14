package sheep.controller.loading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.view.loading.WelcomeView;

public class CharacterSelectionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if( command.equals( WelcomeView.SMASHER) ) {
			System.out.println(command);
		} 
		else if( command.equals( WelcomeView.SUMMONER) ) {
			System.out.println(command);
		}
		else if( command.equals( WelcomeView.SNEAK) ) {
			System.out.println(command);
		}
	}

}
