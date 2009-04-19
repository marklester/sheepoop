package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.GameStateType;
import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.items.Takeable;

public class UseItemAction extends AbstractAction {

	private static final long serialVersionUID = 4417615613309055699L;
	private Model model;
	
	public UseItemAction(Model model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			//while (model.getGameState().equals(GameStateType.PAUSED_ACTION_MENU))
				//this.wait();
		} catch (Exception e) {		}
	}
}