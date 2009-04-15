package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import sheep.controller.Controller;
import sheep.model.Model;
import sheep.model.loading.ModelLoader;
import sheep.view.View;
import sheep.view.loading.WelcomeView;

public class LoadGameAction extends AbstractAction {
	
	private static final long serialVersionUID = 1965146620020410561L;	

	private WelcomeView wv;
	
	public LoadGameAction(WelcomeView wv) {
		this.wv = wv;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		JFileChooser jc = new JFileChooser();
		jc.setFileFilter( new FileNameExtensionFilter( "Sheepoop Save Files", "poop" ) );
		int status = jc.showOpenDialog( wv );
		
		if( status == JFileChooser.APPROVE_OPTION ) {
			ModelLoader loader = new ModelLoader( jc.getSelectedFile() );
			
			Model model = loader.load();
			View view = new View( model );
			
			new Controller( model, view );
			
			wv.dispose();
		}
	}
}