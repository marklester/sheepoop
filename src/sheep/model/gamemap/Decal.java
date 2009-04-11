package sheep.model.gamemap;

/**
 * 
 * @author Phil Freo
 */
public class Decal extends Locatable {

	public Decal(String id, GameMap map, Location loc) {
		super(id, map, loc);
	}

	private static final long serialVersionUID = -6244165739481933022L;

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}
}