package edu.hm.labyrinth.board;

import java.util.ArrayList;
import java.util.List;

import edu.hm.labyrinth.generator.TileGenerator;
import edu.hm.labyrinth.tile.Nook;
import edu.hm.labyrinth.tile.Tile;
import edu.hm.labyrinth.tile.Tri;

public class Board {

	public static final int NUMBER_OF_LAST_MAGIC_ITEM = 25;
	public static final int NUMBER_OF_CONTIGUOUS_MAGIC_ITEMS = 20;
	public static final int SIZE = 7;
	public static final int NUMBER_OF_CONERS = 4;

	private List<Field> fields = new ArrayList<Field>();
	private List<Player> players = new ArrayList<Player>();
	private List<MagicItem> magicitems = new ArrayList<MagicItem>();

	public Board(TileGenerator o) {

		if (o == null) {
			throw new NullPointerException("tile generator is null.");
		}
		List<Tile> tiles = new ArrayList<Tile>();
		tiles = o.createTiles();
		if (tiles.size() != TileGenerator.NUMBER_OF_TILES) {
			throw new IllegalArgumentException();
		}
//		Tile tri1 = new Nook();
//		Tile tri2 = new Nook();
//		tri2.rotateClockwise();
//		generateField(0, tri1, 0, 0);
//		generateField(0, tri2, 0, 2);
//		fields.add(new Field(tri1, 2, 2));
//		fields.add(new Field(tri2, 2, 4));
//		generateCorners();
		generateMiddle();
//		generateMargins();
		System.out.println(fields.size());

	}

	/**
	 * @param rotations
	 *            number of rotates
	 * @param tile
	 *            tile
	 * @param row
	 *            row
	 * @param column
	 *            column
	 */
	private void generateField(int rotations, Tile t, int row,
			int column) {
		Tile tile = t;
		for (int i = 0; i < rotations; i++) {
			t.rotateClockwise();
		}
		fields.add(new Field(tile, row, column));
	}

	private void generateCorners() {
		Nook nook = new Nook();

		for (int i = 0; i < NUMBER_OF_CONERS; i++) {
			if (i == 0) {
				generateField(0, nook, SIZE - 1, SIZE - 1);
			} else if (i == 1) {
				generateField(1, nook, SIZE - 1, 0);
			} else if (i == 2) {
				generateField(2, nook, 0, 0);
			} else {
				generateField(3, nook, 0, SIZE - 1);
			}
		}
	}

	private void generateMiddle() {
		Tri tri = new Tri();

		 for (int i = 0; i < NUMBER_OF_CONERS; i++) {
		 if (i == 0) {
		 generateField(0, tri, 2, 4);
		 } else if (i == 1) {
		 generateField(1, tri, 4, 4);
		 } else if (i == 2) {
		 generateField(1, tri, 4, 2);
		 } else {
		 generateField(1, tri, 2, 0);
		 }
		 }

	}

	private void generateMargins() {
		Tri tri = new Tri();
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {

				if (column % 2 == 0 && row % 2 == 0) {
					if (column == 0 && !(row == 0 || row == SIZE - 1)) {
						generateField(0, tri, row, column);
					}
					if (row == SIZE - 1 && !(column == 0 || column == SIZE - 1)) {
						generateField(1, tri, row, column);
					}
					if (column == SIZE - 1 && !(row == 0 || row == SIZE - 1)) {
						generateField(1, tri, row, column);

					}
					if (row == 0 && !(column == 0 || column == SIZE - 1)) {
						generateField(1, tri, row, column);
					}

				}
			}
		}
	}

	/**
	 * Returns the class name as a String.
	 * 
	 * @param object
	 *            any object
	 * @return the class name.
	 */
	public static String getClassName(Object object) {

		String input = object.getClass().toString();
		return input.substring(input.lastIndexOf('.') + 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Board [fields=" + fields + "]";
	}

}
