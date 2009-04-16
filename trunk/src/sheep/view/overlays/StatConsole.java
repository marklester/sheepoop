package sheep.view.overlays;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import sheep.model.entities.Avatar;
import sheep.model.entities.CharacterStats;
import sheep.model.entities.StatChange;
import sheep.model.entities.StatChangeObserver;
import sheep.model.entities.StatType;
import sheep.view.util.ResourceLoader;

/**
 * 
 * @author Jason Mac
 *
 */

public class StatConsole extends Overlay implements StatChangeObserver {

	private CharacterStats stats;
	private static final int width = 300;
	private static final int height = 200; 
	private static final int v_spacer = 21;	//vertical spacer
	private static final int h_spacer = 220;	//horizontal spacer	
	private static final int bar_width = 15;
	private final float max_life;
	private final float max_mana;
	
	public StatConsole(int posX, int posY, Avatar avatar) {
		super(posX, posY);
		this.stats = avatar.getStats();
		max_life = stats.get(StatType.MAX_LIFE);
		max_mana = stats.get(StatType.MAX_MANA);
	}

	@Override
	public void update(StatChange msg) {
		
	}

	@Override
	public void paint(Graphics2D g) {
		Composite original = g.getComposite();
		int i = 1;
		Font myFont = getFont().deriveFont(16f);
		g.setFont(myFont);
		g.setBackground(Color.BLACK);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f));
		g.fillRect(getPosX(), getPosY(), width, height);
		g.setColor(Color.white);
		
		g.drawString("Lives", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.LIVES_LEFT)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Experience", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.EXPERIENCE)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Level", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.LEVEL)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Strength", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.STRENGTH)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Agility", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.AGILITY)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Intellect", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.STRENGTH)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Speed", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.SPEED)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Offensive Rating", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.OFFENSIVE_RATING)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		g.drawString("Defensive Rating", getPosX(), getPosY() + v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.DEFENSIVE_RATING)), getPosX() + h_spacer, getPosY() + v_spacer*i++);
		
		//Life Bar
		float lifeHeight = ((max_life - stats.get(StatType.LIFE)) / max_life) * (getHeight());
		g.setColor(Color.red);
		g.fillRect(getWidth(), getPosY(), bar_width, getHeight());
		g.setColor(Color.black);
		g.fillRect(getWidth(), getPosY(), bar_width, (int)lifeHeight);
		
		//Mana Bar
		float manaHeight = ((max_mana - stats.get(StatType.MANA)) / max_mana) * (getHeight());
		g.setColor(Color.blue);
		g.fillRect(getWidth()-bar_width-10, getPosY(), bar_width, getHeight());
		g.setColor(Color.black);
		g.fillRect(getWidth()-bar_width-10, getPosY(), bar_width, (int)manaHeight);
		
		g.setComposite(original);
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}
}