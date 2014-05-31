package edu.hm.labyrinth;

import java.util.ArrayList;

public class Player {

	private final Color color;
	private int magicWands;
	private ArrayList<MagicItem> magicItems = new ArrayList<MagicItem>();
	private final int magicWandValue = 2;

	public Player(Color color) {
		this.color = color;
		this.magicWands = 3;
	}

	public void addMagicItemFound(MagicItem magicItems) {
		this.magicItems.add(magicItems);
	}

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
