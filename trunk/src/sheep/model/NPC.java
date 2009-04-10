package model;

public class NPC extends model.Character {
	public model.AI intelligence;
	model.AI unnamed_AI_;

	public NPC(model.Model model) {
		throw new UnsupportedOperationException();
	}

	public boolean blocks(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	public void talk(model.Character character) {
		throw new UnsupportedOperationException();
	}

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}

	public void registerObserver(model.Observer<T> observer) {
		throw new UnsupportedOperationException();
	}

	public void removeObserver(model.Observer<T> observer) {
		throw new UnsupportedOperationException();
	}

	public void notifyObservers() {
		throw new UnsupportedOperationException();
	}
}