package sheep.view.overlays;

import java.awt.Color;
import java.awt.Graphics2D;

import sheep.model.entities.Avatar;
import sheep.model.entities.StatChange;
import sheep.model.entities.StatChangeObserver;

public class StatConsole extends Overlay implements StatChangeObserver {

	private final Avatar avatar;
	
	private static int width = 300;
	private static int height = 200;
	
	public StatConsole(int posX, int posY, Avatar avatar) {
		super(posX, posY);
		this.avatar = avatar;
	}

	@Override
	public void update(StatChange msg) {
		
	}

	@Override
	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(getPosX(), getPosY(), width, height);
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}
}