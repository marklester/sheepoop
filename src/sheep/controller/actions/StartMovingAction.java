package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.Model;
import sheep.model.gamemap.Direction;

/**
 * Tell an entity to start moving in the given direction
 * @author Phil Freo
 */
public class StartMovingAction extends AbstractAction {

	private static final long serialVersionUID = -1525383742655315660L;
	private final Model model;
	private final Direction direction;

	public StartMovingAction(Model model, Direction dir) {
		this.model = model;
		this.direction = dir;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!model.isPaused()) {
			model.getMover().startMoving(direction);
		}
	}

}