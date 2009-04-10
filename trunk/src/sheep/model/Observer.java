package model;

public interface Observer<T extends model.ObservationType> {

	public void update(T msg);
}