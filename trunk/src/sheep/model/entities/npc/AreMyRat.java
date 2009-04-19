package sheep.model.entities.npc;

import java.util.Random;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.entities.npc.ai.AngryAI;
import sheep.model.entities.npc.ai.VillagerAI;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;
import sheep.model.occupations.Sneak;
import sheep.model.skills.PassiveSkill;

public class AreMyRat extends NPC {
	private static final long serialVersionUID = 6747342338321148905L;
	private String[] indifferent = {"Are My?", "OH Arm MY!"};
	private String[] unfriendly = {"ARE MY!", "ARE ARE MYYYYY!" };
	
	public AreMyRat(Model model, Location loc) {
		super("AreMyRat", model, loc, new Sneak(), 20, new VillagerAI(model), new AngryAI(model));
		this.getStats().change(StatType.MONEY, 0);
		affectHostility(0);
	}
	
	public boolean blocks( Entity ent ){
		//if( ent == getModel().getAvatar() )
			//this.talk( (Character) ent );
		return super.blocks(ent);
	}
	
	public void startMoving( Direction d ){
		//do nothing bitches!
	}
	
	public void talk(Character character) {
		Random r = new Random();
		String message = "";
		if( this.getHostility() < 25 ){
			if( this.getInventory().getSize() < 1){
				character.hearMessage(this, "I'd love to trade but I'm out of items!");
				return;
			}
			
			int rand = r.nextInt( this.getInventory().getSize() ) + 1;
			int count = 1;
			String question = "";
			
			for( Takeable item : this.getInventory().get() ){
				if( count == rand ){
					int value = (int) ( (double) item.getPrice() * ( (double) this.getSkill( PassiveSkill.BARGAIN ) / (double) character.getSkill( PassiveSkill.BARGAIN ) ) );
					question = "Would you like to buy my " + item.getID() + " for " + value + " nuggets?";
					break;
				}
				count++;
			}
			
			character.hearQuestion(this, question);
			return;
		}else if( this.getHostility() < 50 ){
			message = indifferent[ r.nextInt( indifferent.length ) ];
		}else if( this.getHostility() < 75 ){
			message = unfriendly[ r.nextInt( unfriendly.length ) ];
		}
		character.hearMessage(this, message);
	}		
}