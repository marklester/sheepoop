package sheep.model.entities;

import sheep.model.Model;
import sheep.model.Observer;
import sheep.model.occupations.Occupation;

public class NPC extends Character {
	public AI intelligence;
	private final Model model;
	private AI ai;
	

	public NPC(Occupation occupation, Model model) {
		super(occupation);
		this.model = model;
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public void talk(Character character) {
		throw new UnsupportedOperationException();
	}

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}

	public void registerObserver(Observer<StatChange> observer) {
		throw new UnsupportedOperationException();
	}

	public void removeObserver(Observer<StatChange> observer) {
		throw new UnsupportedOperationException();
	}

	public void notifyObservers() {
		throw new UnsupportedOperationException();
	}
}