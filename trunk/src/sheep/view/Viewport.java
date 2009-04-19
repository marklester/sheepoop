package sheep.view;

import java.awt.Dimension;

import javax.swing.JPanel;

import sheep.model.entities.Avatar;
import sheep.view.util.ResourceLoader;

public class Viewport extends JPanel {

	private static final long serialVersionUID = -7115001668270029395L;
	public static final Dimension BUT_SIZE = new Dimension(AreaViewport.TILE_SIZE, AreaViewport.TILE_SIZE);
	private Avatar avatar;
	private boolean isVisible = false;
	private ResourceLoader resLoader;

	public Viewport(Avatar av){
		this.avatar = av;
		this.resLoader = ResourceLoader.getInstance();
	}
	
	public Viewport(Avatar av, int w, int h) {
		this.avatar = av;
		this.setPreferredSize(new Dimension(w,h));
		this.resLoader = ResourceLoader.getInstance();
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

	public ResourceLoader getResLoader() {
		return this.resLoader;
	}

}
