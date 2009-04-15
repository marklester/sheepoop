package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.Model;

/**
 * Tell the entity to stop moving (called on keyup)
 * @author Phil Freo
 */
public class StopMovingAction extends AbstractAction {

	private static final long serialVersionUID = 1133576572113102227L;
	private final Model model;
	
	public StopMovingAction(Model model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.getMover().stopMoving();
	}
}