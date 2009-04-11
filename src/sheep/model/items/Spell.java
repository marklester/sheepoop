package sheep.model.items;


public abstract class Spell extends Weapon {

	/**
	 * this should actually attack
	 */
	public void actionPerformed() {
		throw new UnsupportedOperationException();
	}
}