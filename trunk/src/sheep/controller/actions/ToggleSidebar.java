package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.view.View;
import sheep.view.Viewport;

public class ToggleSidebar extends AbstractAction {

	private static final long serialVersionUID = -3568227606694335508L;
	private final View view;
	private final Viewport first;
	private final Viewport second;
	private boolean showingFirst = true;

	public ToggleSidebar(View view, Viewport first, Viewport second) {
		this.view = view;
		this.first = first;
		this.second = second;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Viewport newOne;
		if (showingFirst) {
			newOne = second;
		} else {
			newOne = first;
		}
		view.showSidebarViewport(newOne);
		showingFirst = !showingFirst;
	}
}