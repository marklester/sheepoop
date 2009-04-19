package sheep.model.entities.npc;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.entities.npc.ai.VillagerAI;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Sneak;

public class AreMyRat extends NPC {
	private static final long serialVersionUID = 6747342338321148905L;
	private String[] mytalks = {"Are My?", "OH Arm MY!"};
	private int currenttalk = 0;
	
	public AreMyRat(Model model, Location loc) {
		super("AreMyRat", model, loc, new Sneak());
		
		setAi(new VillagerAI(this, model));
		this.getStats().change(StatType.MONEY, 0);
	}
	
	public void talk(Character character) {
		
		if( mytalks!=null && currenttalk < mytalks.length ) {
			character.hearMessage( this, mytalks[currenttalk] );
		}
		
		if( mytalks!=null && currenttalk==mytalks.length ) {
			currenttalk=0;
		} else {
			currenttalk++;
		}
	}
}