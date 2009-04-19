package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.GameStateType;
import sheep.model.Model;
import sheep.view.View;

public class ReturnToGameAction extends AbstractAction {

	private static final long serialVersionUID = 6119775843258180224L;
	private Model model;
	private View view;

	public ReturnToGameAction(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// Back to game play
		model.setState(GameStateType.PLAYING);
		model.getAvatar().setInteractingCharacter(null);
		model.startTime();
		view.getLayeredPane().grabFocus();
	}
}