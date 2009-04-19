package sheep.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.model.Model;
import sheep.view.View;


public class InteractionViewportListener implements ActionListener {

	private final Model model;
	private final View view;
	
	public InteractionViewportListener(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Inventory button was clicked: " + e.getActionCommand());
	}
}