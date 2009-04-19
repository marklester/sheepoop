package sheep.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import sheep.model.entities.Avatar;
import sheep.model.skills.PerformableSkill;

/**
 * 
 * @author Jason Mac
 *
 */

public class AddSkillPointActionListener implements ActionListener {

	private final Avatar avatar;
	private PerformableSkill skill;

	
	//Constructs a listener for the Armor at a specific body part of the avatar
	public AddSkillPointActionListener(Avatar avatar, PerformableSkill pSkill) {
		this.avatar = avatar;
		this.skill = pSkill;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		List<PerformableSkill> list = avatar.getPerformableSkills();
		avatar.addSkillPoint( list.get(list.indexOf(skill)) );
	}

}
