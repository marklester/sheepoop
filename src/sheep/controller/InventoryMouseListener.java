package sheep.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sheep.model.GameStateType;
import sheep.model.entities.Avatar;
import sheep.model.items.Takeable;


/**
 * 
 * @author Jason Mac
 *
 */

public class InventoryMouseListener implements MouseListener {

	private final Avatar avatar;
	private final Takeable item;
	
	public InventoryMouseListener(Avatar avatar, Takeable item) {
		this.avatar = avatar;
		this.item = item;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (avatar.getModel().getGameState().equals(GameStateType.PAUSED_ACTION_MENU))
				item.use(avatar.getInteractingCharacter());	
			item.use(avatar);			
		}
		else if (e.getButton() == MouseEvent.BUTTON3 || e.getButton() == MouseEvent.BUTTON2)
			avatar.drop(item);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}