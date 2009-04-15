package sheep.controller;

import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import sheep.controller.actions.QuitAction;
import sheep.controller.actions.StartMovingAction;
import sheep.model.GameStateChange;
import sheep.model.GameStateObserver;
import sheep.model.Model;
import sheep.model.gamemap.Direction;
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
	InputMap inputMap;
	ActionMap actionMap;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		// Get input and action maps
		inputMap = view.getAreaViewport().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		actionMap = view.getAreaViewport().getActionMap();
		
		setKeyBindings();
	}

	/**
	 * Set all keyboard inputs with their corresponding actions
	 */
	private void setKeyBindings() {
		// TODO we need to somehow deal with saving/loading/initial keybindings
		
		// Quit
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "quit");
		actionMap.put("quit", new QuitAction());
		
		// Movement
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0), "moveN");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "moveN");
		actionMap.put("moveN", new StartMovingAction(model.getMover(), Direction.N));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0), "moveNE");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "moveNE");
		actionMap.put("moveNE", new StartMovingAction(model.getMover(), Direction.NE));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0), "moveSE");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "moveSE");
		actionMap.put("moveSE", new StartMovingAction(model.getMover(), Direction.SE));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0), "moveS");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "moveS");
		actionMap.put("moveS", new StartMovingAction(model.getMover(), Direction.S));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0), "moveSW");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "moveSW");
		actionMap.put("moveSW", new StartMovingAction(model.getMover(), Direction.SW));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0), "moveNW");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "moveNW");
		actionMap.put("moveNW", new StartMovingAction(model.getMover(), Direction.NW));
		
	}

	/**
	 * Notification of change in game state, for example we need to get a input
	 * from the user before the game can continue
	 */
	public void update(GameStateChange msg) {

	}
}