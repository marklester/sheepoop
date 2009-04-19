package sheep.view.overlays;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import sheep.model.entities.Avatar;
import sheep.model.skills.PerformableSkill;

/**
 * Will be drawn on top of the AreaViewPort. Shows what things are bound to the
 * hotkeys Only allows performable skills
 */
public class HotBarConsole extends Overlay {

	BufferedImage myImage;
	private List<PerformableSkill> skills;
	private static final int v_spacer = 21; // vertical spacer
	private static final int h_spacer = 30; // horizontal spacer
	private static int width = 200;
	private int height;

	public HotBarConsole(int posX, int posY, Avatar avatar) {
		super(posX, posY - (20 + 2 * v_spacer + v_spacer * avatar.getPerformableSkills().size()));
		this.skills = avatar.getPerformableSkills();
		this.height = 2 * v_spacer + v_spacer * this.skills.size();
		init();
	}

	private void init()
	{
		myImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics2D g = myImage.createGraphics();
		Font myFont = getFont().deriveFont(16f);
		g.setFont(myFont);
		g.setColor(Color.BLACK);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f));
		g.fillRect(getPosX(), getPosY(), width, height);
		g.setColor(Color.WHITE);

		g.drawString("#", getPosX() + 10, getPosY() + v_spacer);
		g.drawString("Skill:", getPosX() + h_spacer, getPosY() + v_spacer);

		int i = 1;
		for (PerformableSkill skill : skills) {
			String key = Integer.toString(i);
			g.drawString(key, 10, v_spacer * (i + 1));
			g.drawString(skill.getID(), h_spacer, v_spacer * (i + 1));
			i++;
		}
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

	public int getHeight() {
		return this.height;
	}

}