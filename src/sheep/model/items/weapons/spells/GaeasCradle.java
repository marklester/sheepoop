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
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.model.gamemap.TemporaryDecal;
public class GaeasCradle extends Boon implements TimeObserver{
	private static final long serialVersionUID = 8808860811466926293L;
	int duration=0;
	int currenttick;
	int radius =2;
	Location center;
	public GaeasCradle(Model model, Location loc){
		super("GaeasCradle", model, loc, 5, 0, 1000);
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
			entry.getValue().add(new TemporaryDecal("GaeasCradleEffect",getModel(),loc,100,duration));
		}
	}
	public void applyEffect(Character e) {
		e.affectStat(StatType.MANA_USED, -getBaseDamage());
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
		if(duration<=0){
			Time.getInstance().removeObserver(this);
		}else{
			duration--;
		}
	}
	@Override
	public int getDamageWith(){
		return 0;
	}
}
