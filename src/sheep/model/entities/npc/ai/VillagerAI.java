package sheep.model.entities.npc.ai;

import sheep.model.Model;
import sheep.model.entities.Avatar;
import sheep.model.entities.npc.NPC;
import sheep.model.gamemap.Direction;

public class VillagerAI extends AI {
	private static final long serialVersionUID = 3836274916586137446L;
	
	public VillagerAI(NPC npc, Model model) {
		super(npc, model);
	}

	public void tick() {
		if( this.getNPC().getHostility() >= 75 )
		{
			this.getNPC().setAi( new AngryAI( this.getNPC(), this.getModel() ) );
			return;
		}
		
		int state = (int) (Math.random() * 50);
		int move = (int) (Math.random() * 6);
		move = move < 3 ? 0 : 3;
		if (state == 25) {
			this.getNPC().startMoving(Direction.values()[move]);
		} else if(state<10){
			this.getNPC().stopMoving();
		}
	}

	@Override
	public void bumpedIntoAvatar(Avatar avatar) {
		getNPC().talk(avatar);
	}
}