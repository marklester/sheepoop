package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.entities.Avatar;

public class UseSkillAction extends AbstractAction {
	public static final int SKILL1=0;
	public static final int SKILL2=1;
	public static final int SKILL3=2;
	private static final long serialVersionUID = 6119775843258180224L;
	private Avatar attacker;
	private int skill_index; //used grab a specific skill from the list;
	public UseSkillAction(Avatar attacker,int skill) {
		skill_index=skill;
		this.attacker = attacker;
	}
	//@Override
	public void actionPerformed(ActionEvent ae) {
		try{
			attacker.getPerformableSkills().get(skill_index).actionPerformed(ae);
		}catch(IndexOutOfBoundsException e){
			System.out.print("Avatar does not have that skill");
		}
	}
}