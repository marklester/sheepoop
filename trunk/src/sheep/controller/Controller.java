package sheep.controller;

import java.util.Vector;

import javax.swing.Action;

import sheep.model.GameStateChange;
import sheep.model.Model;
import sheep.model.Observer;
import sheep.view.View;

public class Controller implements Observer<GameStateChange> {
	private View view;
	private Model model;
	private Vector<Action> action = new Vector<Action>();
	private InteractionViewportListener interactionViewportListener;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void update(GameStateChange msg) {
	}
}