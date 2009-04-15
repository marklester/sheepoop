package sheep.view;

import java.awt.Dimension;

import javax.swing.JPanel;

import sheep.controller.TradeButtonsActionListener;
import sheep.model.entities.Avatar;

public class Viewport extends JPanel {

	private Avatar avatar;

	public Viewport(Avatar av){
		this.avatar = av;
	}
	
	public Viewport(Avatar av, int w, int h) {
		this.avatar = av;
		this.setPreferredSize(new Dimension(w,h));
	}
	
	
	public void setActionListener(TradeButtonsActionListener al) {
		throw new UnsupportedOperationException();
	}
	
	public Avatar getAvatar() {
		return this.avatar;
	}
	
}
