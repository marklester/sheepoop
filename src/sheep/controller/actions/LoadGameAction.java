package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import sheep.model.Model;
import sheep.view.loading.WelcomeView;

public class LoadGameAction extends AbstractAction {
	
	private static final long serialVersionUID = 1965146620020410561L;	
	private WelcomeView wv;
	
	public LoadGameAction(WelcomeView wv) {
		this.wv = wv;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Load Game");

	}

}