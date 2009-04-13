package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import sheep.model.Model;

public class StartGameAction extends AbstractAction {
	
	private static final long serialVersionUID = 1965146620020410561L;
	private Icon icon;
	
	
	public StartGameAction(Icon icon) {
		this.icon = icon;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("New Game");

	}

}
