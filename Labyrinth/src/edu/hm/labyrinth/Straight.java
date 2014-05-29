package edu.hm.labyrinth;

public class Straight extends Tile
{

	/**
	 * @param directions
	 */
	public Straight()
	{
		super(new Direction[]{Direction.NORTH, Direction.SOUTH});
	}

}
