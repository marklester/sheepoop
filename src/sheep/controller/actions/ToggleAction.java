package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.view.overlays.Overlay;


public class ToggleAction extends AbstractAction {

	private static final long serialVersionUID = -3568227606694335508L;
	private Overlay ol;
	
	public ToggleAction(Overlay ol) {
		this.ol = ol;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ol.toggleVisibility();	
	}
}