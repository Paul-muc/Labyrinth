package edu.hm.labyrinth.board;

/**
 * Represents a magic item with value.
 * 
 * @author Paul Seer
 * 
 */
public class MagicItem {
	/**
	 * value of the magic item as an Integer.
	 */
	private final int value;

	/**
	 * Constructs a magic item.
	 * 
	 * @param value
	 *            of the magic item. It's value should be between 1 and 20 or
	 *            25.
	 */
	public MagicItem(final int value) {
		if (value == 25) {
			this.value = value;
		} else if (value > 0 && value < 21) {
			this.value = value;
		} else {
			throw new NullPointerException("Falscher Wert für das magic item.");
		}
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MagicItem [value=" + value + "]";
	}

}
