package edu.hm.labyrinth.board;

import edu.hm.labyrinth.tile.Tile;

/**
 * Represents a field with a row, column, magicItem, player and tile. The class
 * Field implements Compareable<Field>.
 * 
 * @author Paul Seer
 * 
 */
public class Field implements Comparable<Field> {

	/**
	 * fields position on the board
	 */
	private final int row, column;
	/**
	 * Magic item on the field
	 */
	private MagicItem magicItem;
	/**
	 * Player on the field
	 */
	private Player player;
	/**
	 * Tile on the field
	 */
	private Tile tile;

	/**
	 * Constructs a new field, which is outside of the board, with a specified
	 * tile. Row and column are -1.
	 * 
	 * @param tile
	 *            Tile on the field
	 */
	public Field(final Tile tile) {
		this(tile, -1, -1);
	}

	/**
	 * Construct a new field with a specified row, column and tile
	 * 
	 * @param tile
	 *            of the field
	 * @param row
	 *            of the field
	 * @param column
	 *            of the field
	 */
	public Field(final Tile tile, final int row, final int column) {
		setTile(tile);
		this.row = row;
		this.column = column;
		this.setPlayer(null);
		this.setMagicItem(null);
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * @param player
	 *            the player to set
	 */
	public void setPlayer(Player player) {
		if (this.player == null) {
		this.player = player;
		}
	}

	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return this.tile;
	}

	/**
	 *
	 * @param tile
	 *            the tile to set
	 */
	public void setTile(final Tile tile) {
		if(getRow()%2 == 0 && getColumn()%2 == 0){
			throw new IllegalArgumentException();
		}
		else {
		this.tile = tile;
		}
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return this.column;
	}

	/**
	 * @return the magicItem
	 */
	public MagicItem getMagicItem() {
		return this.magicItem;
	}

	/**
	 * @param magicItem
	 *            the magicItem to set
	 */
	public void setMagicItem(final MagicItem magicItem) {
		this.magicItem = magicItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final Field field) {
		if(field == null){
			throw new NullPointerException();
		}
		MagicItem other = field.getMagicItem();

		// this is null
		if (this.getMagicItem() == null) {
			if (other == null) {
				return 0;
			}
			else {
				return +1;
			}
			// other is null and this is not null
		}
		else if (other == null) {
			return -1;
			// this is lower
		}
		else if (this.getMagicItem().getValue() < other.getValue()) {
			return -1;
			// other is lower
		}
		else if (this.getMagicItem().getValue() > other.getValue()) {
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
		return "Field [row=" + row + ", column=" + column
				+ ", tile=" + tile + "]" + ", magicItem=" + magicItem;
		//+ ", player=" + player 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
	}
		Field other = (Field) obj;
		if (column != other.column) {
			return false;
		}
		if (row != other.row) {
			return false;
		}
		return true;
	}
}
