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
import sheep.controller.actions.ToggleGridAction;
import sheep.controller.actions.TogglePauseGameplayAction;
import sheep.controller.actions.UseSkillAction;
import sheep.controller.actions.UseWeaponAction;
import sheep.model.GameStateChange;
import sheep.model.GameStateObserver;
import sheep.model.Model;
import sheep.model.gamemap.Direction;
import sheep.model.loading.KeySettings;
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
		inputMap = new InputMap();
		actionMap = new ActionMap();
//		inputMap = view.getAreaViewport().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
//		actionMap = view.getAreaViewport().getActionMap();

		setKeyBindings();

		model.registerObserver(this);
		model.startTime();
	}

	/**
	 * Set all keyboard inputs with their corresponding actions
	 */
	private void setKeyBindings() {
		// TODO we need to somehow deal with saving/loading/initial keybindings
		
		KeySettings ks = new KeySettings();
		
		// Quit
		ks.put("quit", KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0) );
		actionMap.put("quit", new QuitAction());

		// Movement
		actionMap.put("stopMoving", new StopMovingAction(model));
		actionMap.put("moveN", new StartMovingAction(model, Direction.N));
		
		ks.put( "moveN", KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0, false) );
		ks.put( "stopMoving", KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0, true) );
		ks.put( "moveN",KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false) );
		ks.put( "stopMoving", KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true) );		

		actionMap.put("moveNE", new StartMovingAction(model, Direction.NE));
		
		ks.put( "moveNE", KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0, false) );
		ks.put( "stopMoving", KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0, true) );
		ks.put( "moveNE", KeyStroke.getKeyStroke(KeyEvent.VK_E, 0, false) );
		ks.put( "stopMoving", KeyStroke.getKeyStroke(KeyEvent.VK_E, 0, true) );
		
		actionMap.put("moveSE", new StartMovingAction(model, Direction.SE));
		
		ks.put( "moveSE", KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0, false) );
		ks.put( "stopMoving",KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0, true) );
		ks.put( "moveSE", KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false) );
		ks.put( "stopMoving", KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true) );
		
		actionMap.put("moveS", new StartMovingAction(model, Direction.S));

		ks.put( "moveS", KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0, false) );
		ks.put( "stopMoving", KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0, true) );
		ks.put( "moveS", KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false) );
		ks.put( "stopMoving", KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true) );
		
		actionMap.put("moveSW", new StartMovingAction(model, Direction.SW));
		
		ks.put( "moveSW", KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0, false) );
		ks.put("stopMoving", KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0, true) );
		ks.put( "moveSW", KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false) );
		ks.put("stopMoving", KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true) );
		
		actionMap.put("moveNW", new StartMovingAction(model, Direction.NW));

		ks.put( "moveNW", KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0, false) );
		ks.put( "stopMoving", KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0, true) );
		ks.put( "moveNW", KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, false) );
		ks.put( "stopMoving", KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, true) );
		
		// Saving
		actionMap.put("saveGame", new SaveGameAction(model));
		ks.put( "saveGame", KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK) );

		// pause/unpause
		actionMap.put("togglePause", new TogglePauseGameplayAction(model));
		ks.put( "togglePause", KeyStroke.getKeyStroke(KeyEvent.VK_P, 0) );

		// Release vehicle
		actionMap.put("releaseVehicle", new ReleaseVehicleAction(model));
		ks.put( "releaseVehicle", KeyStroke.getKeyStroke(KeyEvent.VK_R, 0) );

		// Toggling
		actionMap.put("toggleStatView", new ToggleAction(view.getAreaViewport().getStatConsole()));
		ks.put( "toggleStatView",KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));

		actionMap.put("toggleMessage", new ToggleAction(view.getAreaViewport().getMessageConsole()));
		ks.put( "toggleMessage", KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0) );
		
		actionMap.put("togglePerformableSkills", new ToggleAction(view.getAreaViewport().getHotBarConsole()));
		ks.put( "togglePerformableSkills", KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0) );
		
		actionMap.put("toggleGrid", new ToggleGridAction(view.getAreaViewport()));
		ks.put( "toggleGrid", KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0) );
		
		
		// Use Weapon
		actionMap.put("useWeapon", new UseWeaponAction(model.getAvatar()));
		ks.put( "useWeapon", KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0) );
		
		// Use Skill
		ks.put( "useSkill1", KeyStroke.getKeyStroke(KeyEvent.VK_1, 0) );
		actionMap.put("useSkill1", new UseSkillAction(model.getAvatar(), UseSkillAction.SKILL1));
		ks.put( "useSkill2", KeyStroke.getKeyStroke(KeyEvent.VK_2, 0) );
		actionMap.put("useSkill2", new UseSkillAction(model.getAvatar(), UseSkillAction.SKILL2));
		ks.put( "useSkill3", KeyStroke.getKeyStroke(KeyEvent.VK_3, 0) );
		actionMap.put("useSkill3", new UseSkillAction(model.getAvatar(), UseSkillAction.SKILL3));
		ks.put( "useSkill4", KeyStroke.getKeyStroke(KeyEvent.VK_4, 0) );
		actionMap.put("useSkill4", new UseSkillAction(model.getAvatar(), UseSkillAction.SKILL4));
		ks.put( "useSkill5", KeyStroke.getKeyStroke(KeyEvent.VK_5, 0) );
		actionMap.put("useSkill5", new UseSkillAction(model.getAvatar(), UseSkillAction.SKILL5));
		ks.put( "useSkill6", KeyStroke.getKeyStroke(KeyEvent.VK_6, 0) );
		actionMap.put("useSkill6", new UseSkillAction(model.getAvatar(), UseSkillAction.SKILL6));
		
		//used to generate default keybindings
//		SettingsSaver ss = new SettingsSaver( new File( "res/defaultSettings.psettings" ) );
//		ss.save( ks );
		
		view.getAreaViewport().setInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW, ks.getComponentInputMap( view.getAreaViewport() ) );
		view.getAreaViewport().setActionMap( actionMap );
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