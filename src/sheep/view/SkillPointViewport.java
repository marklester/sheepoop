package sheep.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sheep.controller.AddSkillPointActionListener;
import sheep.controller.InventoryMouseListener;
import sheep.controller.TradeButtonsActionListener;
import sheep.model.entities.Avatar;
import sheep.model.entities.SkillPointChangeObserver;
import sheep.model.entities.npc.NPC;
import sheep.model.items.Takeable;
import sheep.model.skills.PassiveSkill;
import sheep.model.skills.PerformableSkill;
import sheep.view.overlays.Overlay;

public class SkillPointViewport extends Viewport implements SkillPointChangeObserver {

	private static final long serialVersionUID = 3484298330273421838L;
	public static final Dimension plusSignSize = new Dimension(40, 40);
	private Font myFont = Overlay.getFont().deriveFont(15f);
	private Image bgImage;
	private ImageIcon plusSignIcon;
	private JPanel mainPanel;

	public SkillPointViewport(Avatar avatar, int w, int h) {
		super(avatar, w, h);
		plusSignIcon = getResLoader().getImageIcon("addSkillPoint");
		bgImage = getResLoader().getImage("sideBarBG");
		setupPanel();
		this.setVisible(true);
		
		getAvatar().registerSkillPointObserver(this);
		
	}
	
	public JPanel createPanel() {
		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setPreferredSize(getPreferredSize());
		mainPanel.setOpaque(false);

		short y = 0;
		short pady = 40;
		short padx = 3;
		for (PerformableSkill pSkill : getAvatar().getPerformableSkills()) {
			
			//Create the label on the left
			GridBagConstraints c_lab = new GridBagConstraints();
			c_lab.anchor = GridBagConstraints.LINE_START;
			c_lab.gridx = 0;
			c_lab.gridy = y;
			c_lab.ipady = pady;
			c_lab.ipadx = padx;
			JLabel tit = new JLabel(pSkill.getID());
			tit.setFont(myFont);
			tit.setForeground(Color.WHITE);
			mainPanel.add(tit, c_lab);
			
			//Create the label for the amount of current points for this skill
			GridBagConstraints c_pnt = new GridBagConstraints();
			//c_pnt.anchor = GridBagConstraints.Center;
			c_pnt.gridx = 1;
			c_pnt.gridy = y;
			c_pnt.ipady = pady;
			c_pnt.ipadx = padx;
			JLabel pnt = new JLabel( "( " +Integer.toString(pSkill.getPoints())+ " )" );
			pnt.setFont(myFont);
			pnt.setForeground(Color.WHITE);
			mainPanel.add(pnt, c_pnt);
			
			//Create the Jbutton on the right
			GridBagConstraints c_but = new GridBagConstraints();
			c_but.anchor = GridBagConstraints.CENTER;
			c_but.gridx = 2;
			c_but.gridy = y++;
			c_but.ipady = pady;
			c_but.ipadx = padx;
			JButton but = new JButton(plusSignIcon);
			but.setPreferredSize(plusSignSize);
			but.setOpaque(false);
			but.setContentAreaFilled(false);
			but.setBorderPainted(false);
			but.addActionListener(new AddSkillPointActionListener(getAvatar(), pSkill));
			mainPanel.add(but, c_but);
		}

		for (Entry<PassiveSkill, Integer> entry : getAvatar().getPassiveSkills()) {
			PassiveSkill pSkill = entry.getKey();
			//Create the label on the left
			GridBagConstraints c_lab = new GridBagConstraints();
			c_lab.anchor = GridBagConstraints.LINE_START;
			c_lab.gridx = 0;
			c_lab.gridy = y;
			c_lab.ipady = pady;
			c_lab.ipadx = padx;
			JLabel tit = new JLabel(pSkill.name());
			tit.setFont(myFont);
			tit.setForeground(Color.WHITE);
			mainPanel.add(tit, c_lab);
			
			//Create the label for the amount of current points for this skill
			GridBagConstraints c_pnt = new GridBagConstraints();
			//c_pnt.anchor = GridBagConstraints.Center;
			c_pnt.gridx = 1;
			c_pnt.gridy = y;
			c_pnt.ipady = pady;
			c_pnt.ipadx = padx;
			JLabel pnt = new JLabel( "( " +entry.getValue()+ " )" );
			pnt.setFont(myFont);
			pnt.setForeground(Color.WHITE);
			mainPanel.add(pnt, c_pnt);
			
			//Create the Jbutton on the right
			GridBagConstraints c_but = new GridBagConstraints();
			c_but.anchor = GridBagConstraints.LINE_END;
			c_but.gridx = 2;
			c_but.gridy = y++;
			c_but.ipady = pady;
			c_but.ipadx = padx;
			JButton but = new JButton(plusSignIcon);
			but.setPreferredSize(plusSignSize);
			but.setOpaque(false);
			but.setContentAreaFilled(false);
			but.setBorderPainted(false);
			but.addActionListener(new AddSkillPointActionListener(getAvatar(), pSkill));
			mainPanel.add(but, c_but);
		}
		
		
		mainPanel.setVisible(true);
		return mainPanel;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(myFont.deriveFont(24f));
		g.setColor(Color.RED);
		g.drawString("Available Skills", 8, 40);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (bgImage != null)
			g.drawImage(bgImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}


	public void setupPanel() {
		if (mainPanel != null)
			remove(mainPanel);
		this.mainPanel = createPanel();
		add(mainPanel);
		this.validate();		
	}

	@Override
	public void update() {
		setupPanel();
	}
	
	

	
}