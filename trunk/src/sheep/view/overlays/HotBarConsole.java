package sheep.view.overlays;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;

import sheep.model.entities.Avatar;
import sheep.model.skills.PerformableSkill;

/**
 * Will be drawn on top of the AreaViewPort. Shows what things are bound to the
 * hotkeys Only allows performable skills
 */
public class HotBarConsole extends Overlay {

	private List<PerformableSkill> skills;
	private static final int v_spacer = 21; // vertical spacer
	private static final int h_spacer = 30; // horizontal spacer
	private static int width = 200;
	private int height;

	public HotBarConsole(int posX, int posY, Avatar avatar) {
		super(posX, posY);
		this.skills = avatar.getPerformableSkills();
		this.height = 2 * v_spacer + v_spacer * this.skills.size();
	}

	@Override
	public void paint(Graphics2D g) {
		Composite original = g.getComposite();
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
			g.drawString(key, getPosX() + 10, getPosY() + v_spacer * (i + 1));
			g.drawString(skill.getID(), getPosX() + h_spacer, getPosY() + v_spacer * (i + 1));
			i++;
		}

		g.setComposite(original);
	}

	public static int getWidth() {
		return width;
	}

	public int getHeight() {
		return this.height;
	}

}