package edu.hm.labyrinth;

public class Field implements Comparable<Field> {

	private final int row;
	private final int column;
	private MagicItem magicItem;
	private Player player;
	private Tile tile;

	public Field(Tile tile) {
		this(tile, -1, -1);
	}

	public Field(Tile tile, int row, int column) {
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
		this.player = player;
	}

	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return this.tile;
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
	public void setMagicItem(MagicItem magicItem) {
		this.magicItem = magicItem;
	}

	@Override
	public int compareTo(Field field) {
		MagicItem other = field.getMagicItem();
		
		//this is null
		if (this.getMagicItem() == null) {
			if (other == null) {
				return 0;
			} else {
				return -1;
			}
			//other is null and this is not null
		} else if (other == null) {
			return 1;
			//this is lower 
		} else if (this.getMagicItem().getValue() < other.getValue()) {
			return -1;
			//other is lower
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
