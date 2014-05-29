package edu.hm.labyrinth;

import java.util.ArrayList;

public class Field implements Comparable<Field> {

	public final ArrayList<Integer> row = new ArrayList<Integer>();
	public final ArrayList<Integer> column = new ArrayList<Integer>();
	public MagicItem magicItem;
	public Player player;
	public Tile tile;

	public Field(Tile tile) {
		this.setTile(tile);
		this.row.add(-1);
		this.column.add(-1);
		this.setPlayer(null);
		this.setMagicItem(null);

	}

	public Field(Tile tile, int row, int column) {
		setTile(tile);
		this.row.add(row);
		this.column.add(column);
		this.setPlayer(null);
		this.setMagicItem(null);
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player
	 *            the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * @param tile
	 *            the tile to set
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}

	/**
	 * @return the row
	 */
	public ArrayList<Integer> getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public ArrayList<Integer> getColumn() {
		return column;
	}

	/**
	 * @return the magicItem
	 */
	public MagicItem getMagicItem() {
		return magicItem;
	}

	/**
	 * @param magicItem
	 *            the magicItem to set
	 */
	public void setMagicItem(MagicItem magicItem) {
		this.magicItem = magicItem;
	}

	@Override
	public int compareTo(Field field) {
		MagicItem other = field.getMagicItem();

		if (this.getMagicItem() == null) {
			if (other == null) {
				return 0;
			} else {
				return -1;
			}
		} else if (other == null) {
			return 1;
		} else if (this.getMagicItem().getValue() < other.getValue()) {
			return -1;
		} else if (this.getMagicItem().getValue() > other.getValue()) {
			return 1;
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Field [row=" + row + ", column=" + column + ", magicItem="
				+ magicItem + ", player=" + player + ", tile=" + tile + "]";
	}

}
