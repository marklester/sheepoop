package sheep.model.entities;



public interface TalkMessageObservable {
	
	public void notifyTalkMessageObservers(TalkMessage msg);

	public void registerObserver(TalkMessageObserver observer);

	public void removeObserver(TalkMessageObserver observer);

}
