package edu.hm.labyrinth;

/**
 * Represents a straight.
 * A straight extends from tile.
 * @author Paul Seer
 *
 */
public class Straight extends Tile {

	/**
	 * Constructs a straight, which is a special tile, with specific directions:
	 * north and south.
	 */
	public Straight() {
		super(new Direction[] { Direction.NORTH, Direction.SOUTH });
	}

}
