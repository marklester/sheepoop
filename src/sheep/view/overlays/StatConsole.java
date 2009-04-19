package sheep.view.overlays;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import sheep.model.entities.Avatar;
import sheep.model.entities.CharacterStats;
import sheep.model.entities.StatChange;
import sheep.model.entities.StatChangeObserver;
import sheep.model.entities.StatType;

/**
 * 
 * @author Jason Mac
 *
 */

public class StatConsole extends Overlay implements StatChangeObserver {

	BufferedImage myImage;
	private CharacterStats stats;
	private static final int width = 300;
	private static final int height = 220; 
	private static final int v_spacer = 21;	//vertical spacer
	private static final int h_spacer = 200;	//horizontal spacer	
	private static final int bar_width = 15;
	
	public StatConsole(int posX, int posY, Avatar avatar) {
		super(posX, posY);
		this.stats = avatar.getStats();
		update(null);
		avatar.registerStatChangeObserver(this);
	}

	@Override
	public void update(StatChange msg) {
		myImage = new BufferedImage(width+25, height, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics2D g = myImage.createGraphics();
		int i = 1;
		Font myFont = getFont().deriveFont(16f);
		g.setFont(myFont);
		g.setColor(Color.BLACK);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f));
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		
		g.drawString("Lives", 2, v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.LIVES_LEFT)), h_spacer, v_spacer*i++);
		
		g.drawString("Experience", 2, v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.EXPERIENCE)), h_spacer, v_spacer*i++);
		
		g.drawString("Level", 2, v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.LEVEL)), h_spacer, v_spacer*i++);
		
		g.drawString("Strength", 2, v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.STRENGTH)), h_spacer, v_spacer*i++);
		
		g.drawString("Agility", 2, v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.AGILITY)), h_spacer, v_spacer*i++);
		
		g.drawString("Intellect", 2, v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.STRENGTH)), h_spacer, v_spacer*i++);
		
		g.drawString("Speed", 2, v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.SPEED)), h_spacer, v_spacer*i++);
		
		g.drawString("Money", 2, v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.MONEY)), h_spacer, v_spacer*i++);
		
		g.drawString("Defensive Rating", 2, v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.DEFENSIVE_RATING)), h_spacer, v_spacer*i++);
		
		g.drawString("Armor Rating", 2, v_spacer*i);
		g.drawString(Integer.toString(stats.get(StatType.ARMOR_RATING)), h_spacer, v_spacer*i++);
		
		//Life Bar
		float max_life = stats.get(StatType.MAX_LIFE);
		float lifeHeight = ((max_life - stats.get(StatType.LIFE)) / max_life) * (getHeight());
		g.setColor(Color.red);
		g.fillRect(getWidth(), 0, bar_width, getHeight());
		g.setColor(Color.black);
		g.fillRect(getWidth(), 0, bar_width, (int)lifeHeight);
		
		//Mana Bar
		float max_mana = stats.get(StatType.MAX_MANA);
		float manaHeight = ((max_mana - stats.get(StatType.MANA)) / max_mana) * (getHeight());
		g.setColor(Color.blue);
		g.fillRect(getWidth()-bar_width-10, 0, bar_width, getHeight());
		g.setColor(Color.black);
		g.fillRect(getWidth()-bar_width-10, 0, bar_width, (int)manaHeight);
		
		
	}

	@Override
	public void paint(Graphics2D g) {
		Composite original = g.getComposite();
		g.drawImage(myImage, getPosX(), getPosY(), null);
		g.setComposite(original);
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}

}