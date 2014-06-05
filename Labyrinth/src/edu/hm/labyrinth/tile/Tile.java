package edu.hm.labyrinth.tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import edu.hm.labyrinth.board.Board;

/**
 * Represents an abstract Tile with an ArrayList of directions.
 * 
 * @author Paul Seer
 * 
 */
public abstract class Tile {

	/**
	 * The ArrayList of directions.
	 */
	private List<Direction> directions = new ArrayList<Direction>();

	/**
	 * Constructs a list, containing directions.
	 * 
	 * @param directions
	 *            is an array of directions
	 */
	protected Tile(final Direction... directions) {
		// for (int i = 0; i < directions.length; i++) {
		// this.directions.add(directions[i]);
		// }
		this.directions = Arrays.asList(directions);

	}

	/**
	 * Whether the specific direction is part of the ArrayList.
	 * 
	 * @param direction
	 *            is a specific direction
	 * @return <code>true</code> if the direction is part of the ArrayList
	 *         directions
	 */
	public boolean isConnectedTo(final Direction direction) {
		for (Direction y : directions) {
			if (y.equals(direction)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Rotate the tile clock wise.
	 */
	public void rotateClockwise() {

		for (int i = 0; i < directions.size(); i++) {
			switch (directions.get(i)) {
			case NORTH:
				directions.set(i, Direction.EAST);
				break;
			case EAST:
				directions.set(i, Direction.SOUTH);
				break;
			case SOUTH:
				directions.set(i, Direction.WEST);
				break;
			case WEST:
				directions.set(i, Direction.NORTH);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * rotate the tile randomly.
	 */
	public void randomlyRotate() {
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(4);
		for (int i = randomNumber; i != 0; i--) {
			this.rotateClockwise();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String output = "";

		for (Direction y : directions) {
			output += y.toString() + " ";
		}

		return output  +" Klasse: " +Board.getClassName(this);
	}

}
