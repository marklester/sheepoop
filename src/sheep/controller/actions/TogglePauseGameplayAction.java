package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.Model;

public class TogglePauseGameplayAction extends AbstractAction {

	private static final long serialVersionUID = -4848278042273717443L;
	private Model model;
	
	public TogglePauseGameplayAction(Model model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if( model.isPaused() )
			model.startTime();
		else
			model.pauseTime();
	}
}