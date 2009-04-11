package sheep.view.overlays;

import java.awt.Component;

import sheep.model.entities.Avatar;

public class SkillViewport extends Component {

	private static final long serialVersionUID = 4267404779359062231L;
	private Avatar avatar;
	
	public SkillViewport(Avatar avatar) {
		this.avatar = avatar;
	}
}