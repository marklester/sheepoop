package sheep.model;

public class GameMap {
	public Map<model.Location, List<model.Locatable>> map;
	model.Model unnamed_Model_;
	model.Locatable unnamed_Locatable_;

	public List<model.Locatable> get(model.Location loc) {
		throw new UnsupportedOperationException();
	}

	public void add(model.Location loc, model.Locatable obj) {
		throw new UnsupportedOperationException();
	}

	public void remove(model.Location loc, model.Locatable obj) {
		throw new UnsupportedOperationException();
	}

	public void notifyOfMovement(model.Location oldLoc, model.Location newLoc, model.Location obj) {
		throw new UnsupportedOperationException();
	}

	public Map<model.Location, List<model.Locatable>> getMapSubset(int origin, int radius) {
		throw new UnsupportedOperationException();
	}
}