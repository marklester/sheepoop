package sheep.model.entities;

public interface TalkMessageObservable {
	
	public void notifyTalkMessageObservers(TalkMessage msg);

	public void registerTalkMessageObserver(TalkMessageObserver observer);

	public void removeTalkMessageObserver(TalkMessageObserver observer);

}
