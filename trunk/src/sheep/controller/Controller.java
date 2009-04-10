package controller;

import view.View;
import model.Model;
import java.util.Vector;
import controller.Action;
import model.Observer;

public class Controller implements Observer {
	private View view;
	private Model model;
	Vector<Action> unnamed_Action_ = new Vector<Action>();
	controller.InteractionViewportListener unnamed_InteractionViewportListener_;

	public Controller(Model model, View view) {
		throw new UnsupportedOperationException();
	}

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}
}