package sheep.controller.loading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import sheep.controller.Controller;
import sheep.model.Model;
import sheep.model.loading.ModelLoader;
import sheep.view.View;
import sheep.view.loading.WelcomeView;

/**
 * Load default key bindings (may be overridden by SettingsActionListener)
 */
public class WelcomeActionListener implements ActionListener {

	private WelcomeView welcomeView;
	
	public WelcomeActionListener( WelcomeView view ) {
		this.welcomeView = view;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String command = ae.getActionCommand();
		
		if( command.equals( WelcomeView.NEW_GAME ) ) {
			welcomeView.displayCharacterSelect();
		}
		else if( command.equals( WelcomeView.LOAD ) ) {
			JFileChooser jc = new JFileChooser();
			jc.setFileFilter( new FileNameExtensionFilter( "Sheepoop Save Files", "poop" ) );
			int status = jc.showOpenDialog( welcomeView );
			
			if( status == JFileChooser.APPROVE_OPTION ) {
				ModelLoader loader = new ModelLoader( jc.getSelectedFile() );
				
				Model model = loader.load();
				System.out.println("got a model " + model);
				System.out.println("got a map " + model.getGameMap());
				View view = new View( model );
				
				new Controller( model, view );
				
				welcomeView.dispose();
			}
		}
		else if( command.equals( WelcomeView.SETTINGS ) )
		{
			welcomeView.displaySettingsView();
		}
	}
}