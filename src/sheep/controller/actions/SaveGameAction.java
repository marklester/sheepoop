package sheep.controller.actions;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import sheep.model.Model;
import sheep.model.loading.ModelSaver;
import sheep.view.View;


public class SaveGameAction extends AbstractAction {

	private static final long serialVersionUID = 1965146620020410560L;

	private final Model model;
	private final View view;

	public SaveGameAction(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		model.pauseTime();
		
		view.fullScreenOff();
		
		JFileChooser jc = new JFileChooser();
		jc.setFileFilter( new FileNameExtensionFilter( "Sheepoop Save Files (*.poop)", "poop" ) );
		jc.setRequestFocusEnabled(true);
		int status = jc.showSaveDialog( null );
		
		if( status == JFileChooser.APPROVE_OPTION ) {
			File file = jc.getSelectedFile();
			
			if( !file.getName().contains( ".poop" ) )
				file = new File( file.getAbsolutePath() + ".poop" );
			
			ModelSaver saver = new ModelSaver( file );
			saver.save( model );
		}
		
		view.fullScreenOn();
		
		model.startTime();
	}
}