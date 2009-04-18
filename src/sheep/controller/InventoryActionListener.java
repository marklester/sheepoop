package sheep.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryActionListener implements ActionListener {

	public InventoryActionListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Inventory button pushed: " + e.getActionCommand());
	}
}