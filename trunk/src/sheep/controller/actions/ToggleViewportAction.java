package sheep.controller.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import sheep.view.View;
import sheep.view.Viewport;
import sheep.view.overlays.Overlay;

/**
 * 
 * @author Jason Mac
 *
 */

public class ToggleViewportAction extends AbstractAction {

	private Viewport viewport;
	private View view;
	
	public ToggleViewportAction(View view, Viewport v) {
		this.viewport = v;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.showViewport(viewport);
	}

}
