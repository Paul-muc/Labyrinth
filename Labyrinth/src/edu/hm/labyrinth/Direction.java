package edu.hm.labyrinth;

public enum Direction
{
	NORTH, EAST, SOUTH, WEST;

	public Direction getOppositeDirection()
	{
		switch (this)
		{
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
