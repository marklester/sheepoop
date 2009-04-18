package sheep.model.loading;

import java.io.Serializable;

import javax.swing.ComponentInputMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class KeySettings implements Serializable {
	
	private static final long serialVersionUID = -6867923771745738694L;
	
	private InputMap keyBindings;
	
	public KeySettings() {
		keyBindings = new InputMap();
	}
	
	public void put( String key, KeyStroke keyStroke ) {
		keyBindings.put( keyStroke, key );
	}

	public InputMap getInputMap() {
		return keyBindings;
	}
	
	public ComponentInputMap getComponentInputMap( JComponent comp ) {

		ComponentInputMap cm = new ComponentInputMap( comp );
		
		for( KeyStroke k : keyBindings.allKeys() )
		{
			cm.put(k, keyBindings.get(k) );
		}
		
		return cm;
	}
}