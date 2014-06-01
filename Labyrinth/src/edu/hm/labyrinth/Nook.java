package edu.hm.labyrinth;
/**
 * Represents a nook.
 * A nook extends from tile.
 * @author Paul Seer
 *
 */
public class Nook extends Tile {

	/**
	 * Constructs a nook, which is a special tile, with specific directions:
	 * north and west.
	 */
	public Nook() {
		super(new Direction[] { Direction.NORTH, Direction.WEST });
	}

}
