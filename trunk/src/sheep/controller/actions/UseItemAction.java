package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.entities.Entity;
import sheep.model.items.Takeable;

public class UseItemAction extends AbstractAction {

	private static final long serialVersionUID = 4417615613309055699L;
	private Takeable item;
	private Entity target;

	public UseItemAction( Entity target, Takeable item ) {
		this.item = item;
		this.target = target;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		item.use( target );
	}
}