package edu.hm.labyrinth.tile;

/**
 * Represents a Direction.
 * @author Paul Seer
 *
 */
public enum Direction {
	NORTH, EAST, SOUTH, WEST;
	/**
	 * Get the opposite direction
	 * 
	 * @return Returns the new opposite Direction
	 */
	public Direction getOppositeDirection() {
		switch (this) {
		case NORTH:
			return SOUTH;
		case SOUTH:
			return NORTH;
		case WEST:
			return EAST;
		case EAST:
			return WEST;
		default:
			return null;
		}
	}
}
