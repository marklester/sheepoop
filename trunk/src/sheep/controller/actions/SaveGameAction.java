package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import sheep.model.Model;
import sheep.model.loading.ModelSaver;


public class SaveGameAction extends AbstractAction {

	private static final long serialVersionUID = 1965146620020410560L;

	private Model model;

	public SaveGameAction(Model model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		model.pauseTime();
		
		JFileChooser jc = new JFileChooser();
		jc.setFileFilter( new FileNameExtensionFilter( "Sheepoop Save Files (*.poop)", "poop" ) );
		int status = jc.showSaveDialog( null );
		
		if( status == JFileChooser.APPROVE_OPTION ) {
			ModelSaver saver = new ModelSaver( jc.getSelectedFile() );
			saver.save( model );
		}
		
		model.startTime();
	}
}