package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.entities.Entity;
import sheep.model.gamemap.Direction;

/**
 * Tell an entity to start moving in the given direction
 * @author Phil Freo
 */
public class StartMovingAction extends AbstractAction {

	private static final long serialVersionUID = -1525383742655315660L;
	private final Entity entity;
	private final Direction direction;
	
	public StartMovingAction(Entity entity, Direction dir) {
		this.entity = entity;
		this.direction = dir;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		entity.startMoving(direction);
	}

}