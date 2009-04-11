package controller;

import java.util.Vector;

import sheep.controller.actions.Action;

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