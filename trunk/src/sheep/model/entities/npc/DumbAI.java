package sheep.model.entities.npc;

import sheep.model.Time;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.GameMap;

public class DumbAI extends AI {

	private static final long serialVersionUID = 3836274916586137446L;
	private int state;
	public DumbAI(NPC npc, GameMap map) {
		super(npc, map);
		state=0;
		Time.getInstance().registerObserver(this);
	}

	public void tick() {
		state = (int)(Math.random()*8);
		if(this.getNPC().isMoving()){
			if(state<4){}else{
				this.getNPC().stopMoving();
			}
		}else{
			if(state<4)
				this.getNPC().startMoving(Direction.S);
			else
				this.getNPC().startMoving(Direction.N);
		}
	}
}