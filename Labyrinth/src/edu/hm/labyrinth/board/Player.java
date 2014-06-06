package edu.hm.labyrinth.board;

import java.util.ArrayList;

/**
 * Represents a player with with color, magic wands and magic items.
 * 
 * @author Paul
 * 
 */
public final class Player {
	/**
	 * Players color.
	 */
	private final Color color;
	/**
	 * The value of the players magic wands.
	 */
	private int magicWands;
	/**
	 * An ArrayList of magic items.
	 */
	private ArrayList<MagicItem> magicItems = new ArrayList<MagicItem>();
	/**
	 * The value of points for a magic wand.
	 */
	private final int magicWandValue = 2;

	/**
	 * Constructs a new player with a color and 3 magic wands.
	 * 
	 * @param color
	 */
	public Player(final Color color) {
		this.color = color;
		this.magicWands = 3;
	}

	/**
	 * Add a magic item to the ArrayList magicItems.
	 * 
	 * @param magicItem
	 */
	public void addMagicItemFound(final MagicItem magicItem) {
		if (magicItem != null) {
			this.magicItems.add(magicItem);
		}
	}

	/**
	 * Whether the player has a magic wand and reduce the value of magic wands.
	 * 
	 * @return <code>true</code> if the player's value of magic wands is higher
	 *         than zero.
	 */
	public boolean reduceMagicWands() {
		if (this.magicWands > 0) {
			this.magicWands--;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the magicWands
	 */
	public int getMagicWands() {
		return magicWands;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		int score = 0;
		for (MagicItem y : magicItems) {
			score += y.getValue();
		}
		score += getMagicWands() * magicWandValue;
		return score;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [color=" + color + ", magicWands=" + magicWands
				+ ", magicItems=" + magicItems + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((magicItems == null) ? 0 : magicItems.hashCode());
		result = prime * result + magicWandValue;
		result = prime * result + magicWands;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// identität
		if (this == obj)
			return true;
		// null Vergleich
		if (obj == null)
			throw new NullPointerException();
		// selber Typ?
		if (getClass() != obj.getClass())
			return false;
		// einzelelne Werte.
		Player other = (Player) obj;
		if (color != other.color)
			return false;
		if (magicItems == null) {
			if (other.magicItems != null)
				return false;
		} else if (!magicItems.equals(other.magicItems))
			return false;
		if (magicWandValue != other.magicWandValue)
			return false;
		if (magicWands != other.magicWands)
			return false;
		return true;
	}

}
