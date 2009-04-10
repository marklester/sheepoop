package model;

public abstract class Spell extends model.Weapon {

	/**
	 * this should actually attack
	 */
	public void actionPerformed() {
		throw new UnsupportedOperationException();
	}
}