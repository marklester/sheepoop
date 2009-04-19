package sheep.controller;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ActionMap;
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
import sheep.controller.actions.ToggleViewportAction;
import sheep.controller.actions.UseSkillAction;
import sheep.controller.actions.UseWeaponAction;
import sheep.model.GameStateChange;
import sheep.model.GameStateObserver;
import sheep.model.Model;
import sheep.model.gamemap.Direction;
import sheep.model.loading.KeySettings;
import sheep.model.loading.SettingsLoader;
import sheep.view.View;

/**
 * Main controller for game play
 * 
 */
public class Controller implements GameStateObserver {
	private View view;
	private Model model;
	private InteractionViewportListener interactionViewportListener;
	private ActionMap actionMap;

	public Controller(Model model, View view) { 
		this.model = model;
		this.view = view;
		this.interactionViewportListener = new InteractionViewportListener(model, view);
		
		// Get input and action maps
		actionMap = new ActionMap();

		setKeyBindings();

		model.registerObserver(this);
		model.startTime();
	}

	/**
	 * Set all keyboard inputs with their corresponding actions
	 */
	private void setKeyBindings() {
		
		SettingsLoader loader = new SettingsLoader();
		KeySettings ks = loader.load();
		
		Map<String, KeyStroke> tempKeys = new HashMap<String,KeyStroke>();
		
		for( KeyStroke k : ks.getInputMap().allKeys() )
		{ 
			tempKeys.put( (String) ks.getInputMap().get(k) , k);
		}
		
		ks.put("stopMoving", KeyStroke.getKeyStroke( tempKeys.get( "moveN" ).getKeyCode(), tempKeys.get( "moveN" ).getModifiers(), true) );
		ks.put("stopMoving", KeyStroke.getKeyStroke( tempKeys.get( "moveNE" ).getKeyCode(), tempKeys.get( "moveNE" ).getModifiers(), true) );
		ks.put("stopMoving", KeyStroke.getKeyStroke( tempKeys.get( "moveNW" ).getKeyCode(), tempKeys.get( "moveNW" ).getModifiers(), true) );
		ks.put("stopMoving", KeyStroke.getKeyStroke( tempKeys.get( "moveS" ).getKeyCode(), tempKeys.get( "moveS" ).getModifiers(), true) );
		ks.put("stopMoving", KeyStroke.getKeyStroke( tempKeys.get( "moveSE" ).getKeyCode(), tempKeys.get( "moveSE" ).getModifiers(), true) );
		ks.put("stopMoving", KeyStroke.getKeyStroke( tempKeys.get( "moveSW" ).getKeyCode(), tempKeys.get( "moveSW" ).getModifiers(), true) );
		
		// Quit
		ks.put("quit", KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0) );
		actionMap.put("quit", new QuitAction());

		// Movement
		actionMap.put("stopMoving", new StopMovingAction(model));
		actionMap.put("moveN", new StartMovingAction(model, Direction.N));
		actionMap.put("moveNE", new StartMovingAction(model, Direction.NE));
		actionMap.put("moveSE", new StartMovingAction(model, Direction.SE));
		actionMap.put("moveS", new StartMovingAction(model, Direction.S));
		actionMap.put("moveSW", new StartMovingAction(model, Direction.SW));
		actionMap.put("moveNW", new StartMovingAction(model, Direction.NW));

		// Saving
		actionMap.put("saveGame", new SaveGameAction(model));
		ks.put( "saveGame", KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK) );

		// pause/unpause
		actionMap.put("togglePause", new TogglePauseGameplayAction(model));
		ks.put( "togglePause", KeyStroke.getKeyStroke(KeyEvent.VK_P, 0) );

		// Toggling
		actionMap.put("toggleStatView", new ToggleAction(view.getAreaViewport().getStatConsole()));
		ks.put( "toggleStatView",KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));

		actionMap.put("toggleMessage", new ToggleAction(view.getAreaViewport().getMessageConsole()));
		ks.put( "toggleMessage", KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0) );
		
		actionMap.put("togglePerformableSkills", new ToggleAction(view.getAreaViewport().getHotBarConsole()));
		ks.put( "togglePerformableSkills", KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0) );
		
		actionMap.put("toggleGrid", new ToggleGridAction(view.getAreaViewport()));
		ks.put( "toggleGrid", KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0) );
		
        actionMap.put("toggleInventory", new ToggleViewportAction(view, view.getInventoryViewport()) );
        ks.put( "toggleInventory", KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0) );
        
        actionMap.put("toggleSkillViewport", new ToggleViewportAction(view, view.getSkillPointViewport()) );
        ks.put( "toggleSkillViewport", KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0) );
		
        // Release vehicle
        actionMap.put("releaseVehicle", new ReleaseVehicleAction(model));

        // Use Weapon
        actionMap.put("useWeapon", new UseWeaponAction(model.getAvatar()));
        
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

		view.getLayeredPane().setInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW, ks.getComponentInputMap( view.getAreaViewport() ) );
		view.getLayeredPane().setActionMap( actionMap );
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
		case PAUSED_ACTION_MENU:
			model.pauseTime();
			view.toggleActionMenu();
			view.getInteractionViewport().setActionListener(interactionViewportListener);
			break;
		default:

		}
	}
}