package sheep.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import sheep.controller.actions.TalkAction;
import sheep.controller.actions.ToggleTradeAction;
import sheep.controller.actions.UseWeaponAction;
import sheep.model.GameStateType;
import sheep.model.Model;
import sheep.model.entities.Avatar;
import sheep.model.entities.Character;
import sheep.view.TradeViewport;
import sheep.view.View;


public class InteractionViewportListener implements ActionListener {

	private final Model model;
	private final View view;
	private final AbstractAction returnToGameAction;
	
	public InteractionViewportListener(Model model, View view, AbstractAction returnToGameAction) {
		this.model = model;
		this.view = view;
		this.returnToGameAction = returnToGameAction;
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
		} 
		else if(cmd.equalsIgnoreCase("useItem")) {
			view.showInventoryViewport();			
			//action = new ToggleTradeAction( view );
			
			//action = new UseItemAction(model.getAvatar(), model.getAvatar().getInventory().get().iterator().next());
		
		}
		else if(cmd.equalsIgnoreCase("trade")) {
			Avatar av = model.getAvatar();
			Character c = av.getInteractingCharacter();
			TradeViewport tv = new TradeViewport( av, c,  new TradeFacilitator(av, c), view.getAreaViewport().getWidth()/2 - 250, view.getAreaViewport().getHeight()/2 - 250 );
			action = new ToggleTradeAction( view );
			tv.addCloseActionListener( action );
			tv.addCloseActionListener(  new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ae) {
					returnToGameAction.actionPerformed(ae);
				}
			});
			view.setTradeViewport( tv );
		} 
		
		// Execute action
		if (action != null) {
			action.actionPerformed(e);
		}
		
		view.toggleActionMenu();
		
		if( !cmd.equalsIgnoreCase( "trade" ) && !cmd.equalsIgnoreCase( "useItem" ) )
			returnToGameAction.actionPerformed(null);
	}
	

}