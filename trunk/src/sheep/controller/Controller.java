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
	Vector<Action> action = new Vector<Action>();
	InteractionViewportListener interactionViewportListener;

	public Controller(Model model, View view) {
		throw new UnsupportedOperationException();
	}

	public void update(GameStateChange msg) {
	}
}