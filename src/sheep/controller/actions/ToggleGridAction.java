package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.view.AreaViewport;


public class ToggleGridAction extends AbstractAction {

	private static final long serialVersionUID = -3568227606694335508L;
	private final AreaViewport v;
	
	public ToggleGridAction(AreaViewport v) {
		this.v = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		v.toggleGrid();	
	}
}