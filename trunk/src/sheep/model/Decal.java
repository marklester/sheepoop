package sheep.model;

public class Decal extends Locatable {

	public Decal(String id) {
		super(id);
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}
}