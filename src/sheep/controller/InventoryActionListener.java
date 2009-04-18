package sheep.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.model.entities.Avatar;
import sheep.model.items.Takeable;

public class InventoryActionListener implements ActionListener {

	private final Avatar avatar;
	private final Takeable item;
	
	public InventoryActionListener(Avatar avatar, Takeable item) {
		this.avatar = avatar;
		this.item = item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		item.use(avatar);
	}
}