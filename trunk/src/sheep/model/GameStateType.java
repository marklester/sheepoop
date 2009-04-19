package sheep.model;

import java.io.Serializable;

/**
 * 
 * @author Phil Freo
 */
public enum GameStateType implements Serializable {
	PLAYING, PAUSED_ACTION_MENU, PAUSED, GAME_OVER;
}