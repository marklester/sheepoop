package sheep.controller;

import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import sheep.controller.actions.QuitAction;
import sheep.model.GameStateChange;
import sheep.model.GameStateObserver;
import sheep.model.Model;
import sheep.view.View;

/**
 * Main controller for game play
 * 
 */
public class Controller implements GameStateObserver {
	private View view;
	private Model model;
	private Vector<Action> action = new Vector<Action>();
	private InteractionViewportListener interactionViewportListener;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		setKeyBindings();
	}

	private void setKeyBindings() {
		
		// TODO this doesn't work yet FIXME
		InputMap inputMap = view.getAreaViewport().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = view.getAreaViewport().getActionMap();
		
		inputMap.put(KeyStroke.getKeyStroke(0, KeyEvent.VK_ESCAPE), "quit");
		actionMap.put("quit", new QuitAction());
		
	}

	/**
	 * Notification of change in game state, for example we need to get a input
	 * from the user before the game can continue
	 */
	public void update(GameStateChange msg) {

	}
}