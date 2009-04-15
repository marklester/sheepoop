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
import sheep.controller.actions.StopMovingAction;
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
	private InputMap inputMap;
	private ActionMap actionMap;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		// Get input and action maps
		inputMap = view.getAreaViewport().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		actionMap = view.getAreaViewport().getActionMap();
		
		setKeyBindings();
		model.startTime();
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
		actionMap.put("stopMoving", new StopMovingAction(model.getMover()));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0, false), "moveN");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "moveN");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "stopMoving");
		actionMap.put("moveN", new StartMovingAction(model.getMover(), Direction.N));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0, false), "moveNE");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0, false), "moveNE");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0, true), "stopMoving");
		actionMap.put("moveNE", new StartMovingAction(model.getMover(), Direction.NE));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0, false), "moveSE");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "moveSE");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "stopMoving");
		actionMap.put("moveSE", new StartMovingAction(model.getMover(), Direction.SE));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0, false), "moveS");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "moveS");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "stopMoving");
		actionMap.put("moveS", new StartMovingAction(model.getMover(), Direction.S));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0, false), "moveSW");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "moveSW");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "stopMoving");
		actionMap.put("moveSW", new StartMovingAction(model.getMover(), Direction.SW));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0, false), "moveNW");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, false), "moveNW");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, true), "stopMoving");
		actionMap.put("moveNW", new StartMovingAction(model.getMover(), Direction.NW));
		
	}

	/**
	 * Notification of change in game state, for example we need to get a input
	 * from the user before the game can continue
	 */
	public void update(GameStateChange msg) {

	}
}