package edu.hm.labyrinth.tile;


/**
 * Represents a tri.
 * A tri extends from tile.
 * @author Paul Seer
 *
 */
public class Tri extends Tile {

	/**
	 * Constructs a tri, which is a special tile, with specific directions:
	 * east, south and west.
	 */
	public Tri() {
		super(
				new Direction[] {Direction.EAST,
						Direction.SOUTH,
						Direction.WEST});
	}

}
