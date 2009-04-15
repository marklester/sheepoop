package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.items.Takeable;

public class UseItemAction extends AbstractAction {

	private static final long serialVersionUID = 4417615613309055699L;
	private Takeable item;

	public UseItemAction(Takeable item) {
		this.item = item;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
	}
}