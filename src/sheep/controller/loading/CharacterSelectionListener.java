package sheep.controller.loading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.model.occupations.Smasher;
import sheep.model.occupations.Sneak;
import sheep.model.occupations.Summoner;
import sheep.view.loading.WelcomeView;

public class CharacterSelectionListener implements ActionListener {

	private WelcomeView wv;
	
	public CharacterSelectionListener(WelcomeView wv) {
		this.wv = wv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if( command.equals( WelcomeView.SMASHER) ) {
			wv.setSelectedOccupation(new Smasher());
		} 
		else if( command.equals( WelcomeView.SUMMONER) ) {
			wv.setSelectedOccupation(new Summoner());
		}
		else if( command.equals( WelcomeView.SNEAK) ) {
			wv.setSelectedOccupation(new Sneak());
		}
	}

}
