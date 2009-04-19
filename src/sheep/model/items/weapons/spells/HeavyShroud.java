package sheep.model.items.weapons.spells;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.TimeObserver;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Decal;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
public class HeavyShroud extends Boon implements TimeObserver{
	private static final long serialVersionUID = 8808860811466926293L;
	int duration=0;
	int currenttick;
	int radius =2;
	Location center;
	public HeavyShroud(Model model, Location loc){
		super("HeavyShroud", model, loc, 5, 0, 1000);
		duration = 5;
	}
	public void actionPerformed(ActionEvent ae) {
		this.duration=5;
		center = this.getUser().getLocation();
		Time.getInstance().registerObserver(this);
		addDecals();
	}
	public void addDecals(){
		Map<Location, List<Locatable>> tiles = getUser().getGameMap().getMapSubset(center, radius);
		for (Entry<Location, List<Locatable>> entry : tiles.entrySet()) {
			Location loc = entry.getKey();
			entry.getValue().add(new Decal("HeavyShroudEffect",getModel(),loc));
		}
	}
	public void removeDecals(){
		//System.out.println("RemoveSkills");
		Map<Location, List<Locatable>> tiles = getUser().getGameMap().getMapSubset(center, radius);
		for (Entry<Location, List<Locatable>> entry : tiles.entrySet()) {
			Location loc = entry.getKey();
			List<Locatable> locatables = entry.getValue();
			for(Locatable l : locatables){
				if(l.getID().compareTo("HeavyShroudEffect")==0){
					getUser().getGameMap().remove(loc, l);
				}
			}
		}
	}
	public void applyEffect(Character e) {
		e.affectStat(StatType.DEFENSIVE_BONUS, getBaseDamage());
	}
	
	public void applyEffects(){
		Map<Location, List<Locatable>> tiles = getUser().getGameMap().getMapSubset(center, radius);
		for (Entry<Location, List<Locatable>> entry : tiles.entrySet()) {
			List<Locatable> locatables = entry.getValue();
			for(Locatable l : locatables){
				if(l instanceof Character){
					applyEffect(((Character) l));
				}
			}
		}
	}
	@Override
	public void tick() {
		if(currenttick==100){
			currenttick=0;
			applyEffects();
			wearOff();
		}
		currenttick++;
	}
	public void wearOff(){
		//System.out.println("Duration:"+duration);
		if(duration<=0){
			Time.getInstance().removeObserver(this);
			removeDecals();
		}else{
			duration--;
		}
	}
}
