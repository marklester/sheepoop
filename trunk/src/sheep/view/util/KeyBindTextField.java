package sheep.view.util;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class KeyBindTextField extends JTextField {

	private static final long serialVersionUID = -82668781700015085L;
	private KeyStroke key;

	public KeyBindTextField( KeyStroke key )
	{
		this.key = key;
		this.displayText();
		this.addFocusListener( new BindFocusListener() );
		this.addKeyListener( new BindKeyListener() );
	}
	
	public KeyBindTextField()
	{
		this( KeyStroke.getKeyStroke( '0' ) );
	}
	
	public KeyStroke getKeyStroke()
	{
		return key;
	}
	
	public void setKeyStroke( KeyStroke key )
	{
		this.key = key;
		displayText();
	}
	
	private void displayText()
	{
		String mod = "";
		if( key.getModifiers() != 0 )
			mod = mod + KeyEvent.getModifiersExText( key.getModifiers() ) + "+";
		this.setText( mod + KeyEvent.getKeyText( key.getKeyCode() ) );
		
	}
	
	class BindFocusListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent fe) {
			setText( "" );
		}

		@Override
		public void focusLost(FocusEvent fe) {
			displayText();
		}
	}
	
	class BindKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent ke) { 
			key = KeyStroke.getKeyStroke( ke.getKeyCode(), ke.getModifiers() );
		}

		@Override
		public void keyReleased(KeyEvent ke) {
			displayText();
		}

		@Override
		public void keyTyped(KeyEvent ke) { }
	}
}