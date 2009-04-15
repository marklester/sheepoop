package sheep.view.overlays;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import sheep.model.entities.Avatar;
import sheep.model.entities.CharacterStats;
import sheep.model.entities.StatChange;
import sheep.model.entities.StatChangeObserver;
import sheep.model.entities.StatType;
import sheep.view.util.ResourceLoader;

public class StatConsole extends Overlay implements StatChangeObserver {

	private CharacterStats stats;
	private static final int width = 300;
	private static final int height = 200; 
	private static final int v_spacer = 25;	//vertical spacer
	private static final int h_spacer = 220;	//horizontal spacer	
	private static final int bar_width = 15;
	private final int max_life;
	private final Font font;
	
	public StatConsole(int posX, int posY, Avatar avatar) {
		super(posX, posY);
		this.stats = avatar.getStats();
		this.max_life = stats.get(StatType.MAX_LIFE);
		font = ResourceLoader.getInstance().getFont("statsFont");
	}

	@Override
	public void update(StatChange msg) {
		
	}

	@Override
	public void paint(Graphics2D g) {
		int i = 1;
		Font myFont = font.deriveFont(16f);
		g.setFont(myFont);
		g.setBackground(Color.BLACK);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f));
		g.fillRect(getPosX(), getPosY(), width, height);
		g.setColor(Color.white);
		
		g.drawString("Lives", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.LIVES_LEFT)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Experience", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.EXPERIENCE)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Strength", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.STRENGTH)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Agility", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.AGILITY)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Intellect", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.STRENGTH)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Offensive Rating", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.OFFENSIVE_RATING)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Defensive Rating", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.DEFENSIVE_RATING)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		int lifeHeight = (stats.get(StatType.LIFE) - max_life) / max_life * getHeight(); 
		g.drawRect(getWidth()-bar_width, getPosY()+2, bar_width, getHeight()-4);
		g.fillRect(getWidth()-bar_width+1, getPosY()+3, bar_width-2, lifeHeight);
		
		/*
		 * 
		 * Still in progress. lifeHeight isn't calculating right. Done for the night.
		 * 
		 */
		
		// TODO - Jason, can you add some left padding to this so the text isn't on the very edge?
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}
}