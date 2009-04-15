package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.Model;


public class PauseGameplayAction extends AbstractAction {

	private static final long serialVersionUID = -4848278042273717443L;
	private Model model;

	
	
	public PauseGameplayAction(Model model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		model.pauseTime();
	}

}