package edu.hm.labyrinth;

import java.util.ArrayList;

/**
 * Represents a player with with color, magic wands and magic items.
 * 
 * @author Paul
 * 
 */
public class Player {
	/**
	 * Players color
	 */
	private final Color color;
	/**
	 * The value of the players magic wands
	 */
	private int magicWands;
	/**
	 * An ArrayList of magic items.
	 */
	private ArrayList<MagicItem> magicItems = new ArrayList<MagicItem>();
	/**
	 * The value of points for a magic wand
	 */
	private final int magicWandValue = 2;

	/**
	 * Constructs a new player with a color and 3 magic wands.
	 * 
	 * @param color
	 */
	public Player(Color color) {
		this.color = color;
		this.magicWands = 3;
	}

	/**
	 * Add a magic item to the ArrayList magicItems.
	 * 
	 * @param magicItems
	 */
	public void addMagicItemFound(MagicItem magicItems) {
		this.magicItems.add(magicItems);
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

}
