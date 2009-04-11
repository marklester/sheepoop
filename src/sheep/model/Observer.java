package sheep.model;

public interface Observer<T extends ObservationType> {

	public void update(T msg);
}