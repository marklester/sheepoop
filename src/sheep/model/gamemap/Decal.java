package sheep.model.gamemap;

import sheep.model.Model;

/**
 * 
 * @author Phil Freo
 */
public class Decal extends Locatable {

	public Decal(String id, Model model, Location loc) {
		super(id, model, loc);
	}

	private static final long serialVersionUID = -6244165739481933022L;

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}
}