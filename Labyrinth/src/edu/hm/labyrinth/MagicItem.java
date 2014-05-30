package edu.hm.labyrinth;
public class MagicItem {


	private final int value;

	public MagicItem(int value) {
		if (value == 25) {
			this.value = value;
		} else if (value > 0 && value < 21) {
			this.value = value;
		} else
			throw new NullPointerException("Falscher Wert für das magic item.");
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MagicItem [value=" + value + "]";
	}

}
