package sheep.view;

import java.awt.Dimension;

import javax.swing.JPanel;

import sheep.model.entities.Avatar;

public class Viewport extends JPanel {

	private static final long serialVersionUID = -7115001668270029395L;
	private Avatar avatar;
	private boolean isVisible = false;

	public Viewport(Avatar av){
		this.avatar = av;
	}
	
	public Viewport(Avatar av, int w, int h) {
		this.avatar = av;
		this.setPreferredSize(new Dimension(w,h));
	}
	
	public Avatar getAvatar() {
		return this.avatar;
	}
	
	public void toggleVisibility() {
		isVisible = !isVisible;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
//	public void paint(Graphics2D g) {
//		super.paint(g);
//	}
	
	
	
}
