package sheep.model.entities;

public interface SkillPointChangeObservable {

	public void notifySkillPointObservers();

	public void registerSkillPointObserver(SkillPointChangeObserver observer);

	public void removeSkillPointObserver(SkillPointChangeObserver observer);
	
}
