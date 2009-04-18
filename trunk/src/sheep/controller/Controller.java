package sheep.controller;

import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import sheep.controller.actions.QuitAction;
import sheep.controller.actions.ReleaseVehicleAction;
import sheep.controller.actions.SaveGameAction;
import sheep.controller.actions.StartMovingAction;
import sheep.controller.actions.StopMovingAction;
import sheep.controller.actions.ToggleAction;
import sheep.controller.actions.TogglePauseGameplayAction;
import sheep.controller.actions.UseSkillAction;
import sheep.controller.actions.UseWeaponAction;
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

		model.registerObserver(this);
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
		actionMap.put("stopMoving", new StopMovingAction(model));
		actionMap.put("moveN", new StartMovingAction(model, Direction.N));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0, false), "moveN");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "moveN");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "stopMoving");
		actionMap.put("moveNE", new StartMovingAction(model, Direction.NE));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0, false), "moveNE");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0, false), "moveNE");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0, true), "stopMoving");
		actionMap.put("moveSE", new StartMovingAction(model, Direction.SE));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0, false), "moveSE");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "moveSE");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "stopMoving");
		actionMap.put("moveS", new StartMovingAction(model, Direction.S));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0, false), "moveS");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "moveS");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "stopMoving");
		actionMap.put("moveSW", new StartMovingAction(model, Direction.SW));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0, false), "moveSW");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "moveSW");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "stopMoving");
		actionMap.put("moveNW", new StartMovingAction(model, Direction.NW));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0, false), "moveNW");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0, true), "stopMoving");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, false), "moveNW");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, true), "stopMoving");

		// Saving
		actionMap.put("saveGame", new SaveGameAction(model));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), "saveGame");

		// pause/unpause
		actionMap.put("togglePause", new TogglePauseGameplayAction(model));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "togglePause");

		// Release vehicle
		actionMap.put("releaseVehicle", new ReleaseVehicleAction(model));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "releaseVehicle");

		// Toggling
		actionMap.put("toggleStatView", new ToggleAction(view.getAreaViewport().getStatConsole()));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "toggleStatView");
		actionMap.put("toggleMessage", new ToggleAction(view.getAreaViewport().getMessageConsole()));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "toggleMessage");
		actionMap.put("togglePerformableSkills", new ToggleAction(view.getAreaViewport().getHotBarConsole()));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "togglePerformableSkills");

		// Use Weapon
		actionMap.put("useWeapon", new UseWeaponAction(model.getAvatar()));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "useWeapon");
		
		// Use Skill
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0), "useSkill1");
		actionMap.put("useSkill1", new UseSkillAction(model.getAvatar(), UseSkillAction.SKILL1));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0), "useSkill2");
		actionMap.put("useSkill2", new UseSkillAction(model.getAvatar(), UseSkillAction.SKILL2));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0), "useSkill3");
		actionMap.put("useSkill3", new UseSkillAction(model.getAvatar(), UseSkillAction.SKILL3));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0), "useSkill4");
		actionMap.put("useSkill4", new UseSkillAction(model.getAvatar(), UseSkillAction.SKILL4));
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0), "useSkill5");
		actionMap.put("useSkill5", new UseSkillAction(model.getAvatar(), UseSkillAction.SKILL5));
	}

	/**
	 * Notification of change in game state, for example we need to get a input
	 * from the user before the game can continue, or the game may be over.
	 */
	public void update(GameStateChange msg) {
		switch (msg.getNewState()) {
		case GAME_OVER:
			// TODO we may need to disable all the keyboard inputs EXCEPT
			// esc=exit
			view.gameOver();
			break;
		default:

		}
	}
}