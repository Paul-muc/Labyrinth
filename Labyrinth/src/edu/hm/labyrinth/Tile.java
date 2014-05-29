package edu.hm.labyrinth;

import java.util.ArrayList;
import java.util.Random;

import edu.hm.labyrinth.Direction;

public abstract class Tile {

	ArrayList<Direction> directions = new ArrayList<Direction>();
	

	protected Tile(Direction... directions) {
		for (int i = 0; i < directions.length; i++) {
			this.directions.add(directions[i]);
		}

	}

	public boolean isConnectedTo(Direction direction) {
		for (Direction y : directions) {
			if (y.equals(direction)) {
				return true;
			}
		}
		return false;
	}

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

		return output;
	}
}
