package sheep.view;

import java.awt.Dimension;

import javax.swing.JPanel;

import sheep.model.NotSerializable;
import sheep.model.entities.Avatar;
import sheep.view.util.ResourceLoader;

public class Viewport extends JPanel implements NotSerializable {

	private static final long serialVersionUID = -7115001668270029395L;
	public static final Dimension BUT_SIZE = new Dimension(AreaViewport.TILE_SIZE, AreaViewport.TILE_SIZE);
	private Avatar avatar;

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
	
	public static ResourceLoader getResLoader() {
		return ResourceLoader.getInstance();
	}
	
}
