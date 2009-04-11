package sheep.model;

public class Decal extends Locatable {

	private static final long serialVersionUID = -6244165739481933022L;

	public Decal(String id) {
		super(id);
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}
}