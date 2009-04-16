package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.entities.Character;
import sheep.model.items.Takeable;

public class UseItemAction extends AbstractAction {

	private static final long serialVersionUID = 4417615613309055699L;
	private Takeable item;
	private Character target;

	public UseItemAction( Character target, Takeable item ) {
		this.item = item;
		this.target = target;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		item.use( target );
	}
}