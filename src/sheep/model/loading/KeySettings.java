package sheep.model.loading;

import java.io.Serializable;

import javax.swing.ActionMap;
import javax.swing.InputMap;

public class KeySettings implements Serializable {
	
	private static final long serialVersionUID = 7414087656523028561L;

	private ActionMap aMap;
	private InputMap iMap;
	
	public KeySettings( InputMap inputMap, ActionMap actionMap ) {
		this.iMap = inputMap;
		this.aMap = actionMap;
	}
	
	public ActionMap getActionMap() {
		return aMap;
	}
	
	public InputMap getInputMap() {
		return iMap;
	}

}
