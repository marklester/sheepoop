package sheep.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;

import sheep.controller.actions.TalkAction;
import sheep.controller.actions.UseItemAction;
import sheep.controller.actions.UseWeaponAction;
import sheep.model.GameStateType;
import sheep.model.Model;
import sheep.view.View;


public class InteractionViewportListener implements ActionListener {

	private final Model model;
	private final View view;
	
	public InteractionViewportListener(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Inventory button was clicked: " + e.getActionCommand());
		
		// Which action
		String cmd = e.getActionCommand();
		AbstractAction action = null;
		if (cmd.equalsIgnoreCase("attack")) {
			action = new UseWeaponAction(model.getAvatar());
		} else if(cmd.equalsIgnoreCase("talk")) {
			action = new TalkAction(model.getAvatar(), model.getAvatar().getInteractingCharacter());
		} else if(cmd.equalsIgnoreCase("useItem")) {
			action = new UseItemAction(model.getAvatar(), model.getAvatar().getInventory().get().iterator().next());
		}  else if(cmd.equalsIgnoreCase("trade")) {
			
		} 
		
		// Execute action
		if (action != null) {
			action.actionPerformed(e);
		}
		
		// Back to game play
		view.toggleActionMenu();
		model.setState(GameStateType.PLAYING);
		model.startTime();
		view.getLayeredPane().grabFocus();
	}
}