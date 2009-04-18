package sheep.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sheep.controller.AddSkillPointActionListener;
import sheep.controller.InventoryMouseListener;
import sheep.controller.TradeButtonsActionListener;
import sheep.model.entities.Avatar;
import sheep.model.entities.npc.NPC;
import sheep.model.items.Takeable;
import sheep.model.skills.PerformableSkill;
import sheep.view.overlays.Overlay;

public class SkillPointViewport extends Viewport {

	private static final long serialVersionUID = 3484298330273421838L;
	public static final Dimension plusSignSize = new Dimension(40, 40);
	private Font myFont = Overlay.getFont().deriveFont(20f);
	private Image bgImage;
	private ImageIcon plusSignIcon;

	public SkillPointViewport(Avatar avatar, int w, int h) {
		super(avatar, w, h);
		plusSignIcon = getResLoader().getImageIcon("addSkillPoint");
		bgImage = getResLoader().getImage("sideBarBG");
		setupPanel();
		this.setVisible(true);
		
	}
	
	public void setupPanel() {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);

		/*
		//Create the title
		GridBagConstraints c_lab = new GridBagConstraints();
		//c_lab.anchor = GridBagConstraints.;
		c_lab.gridx = 0;
		c_lab.gridy = y;
		c_lab.ipady = pad;
		JLabel lab = new JLabel(pSkill.getID());
		lab.setFont(myFont);
		lab.setForeground(Color.WHITE);
		this.add(lab, c_lab);
		*/
		
		short y = 0;
		short pad = 50;
		for (PerformableSkill pSkill : getAvatar().getPerformableSkills()) {
			
			//Create the label on the left
			GridBagConstraints c_lab = new GridBagConstraints();
			c_lab.anchor = GridBagConstraints.LINE_START;
			c_lab.gridx = 0;
			c_lab.gridy = y;
			c_lab.ipady = pad;
			JLabel lab = new JLabel(pSkill.getID());
			lab.setFont(myFont);
			lab.setForeground(Color.WHITE);
			this.add(lab, c_lab);
			
			//Create the Jbutton on the right
			GridBagConstraints c_but = new GridBagConstraints();
			c_but.anchor = GridBagConstraints.CENTER;
			c_but.gridx = 1;
			c_but.gridy = y++;
			c_but.ipady = pad;
			JButton but = new JButton(plusSignIcon);
			but.setPreferredSize(plusSignSize);
			but.setOpaque(false);
			but.setContentAreaFilled(false);
			but.setBorderPainted(false);
			but.addActionListener(new AddSkillPointActionListener(getAvatar(), pSkill));
			this.add(but, c_but);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (bgImage != null)
			g.drawImage(bgImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	
}