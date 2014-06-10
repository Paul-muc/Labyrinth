package edu.hm.labyrinth.board;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import edu.hm.labyrinth.generator.TileGenerator;
import edu.hm.labyrinth.tile.Direction;
import edu.hm.labyrinth.tile.Nook;
import edu.hm.labyrinth.tile.Tile;
import edu.hm.labyrinth.tile.Tri;

public class Board {
	// TODO Java doc
	/**
	 * 
	 */
	public static final int NUMBER_OF_LAST_MAGIC_ITEM = 25;
	/**
	 * 
	 */
	public static final int NUMBER_OF_CONTIGUOUS_MAGIC_ITEMS = 20;
	/**
	 * 
	 */
	public static final int SIZE = 7;
	/**
	 * 
	 */
	public static final int MAX_PLAYER = 4;
	/**
	 * 
	 */
	public static final int NUMBER_OF_CONERS = 4;
	/**
	 * list of fields.
	 */
	private List<Field> fields = new ArrayList<Field>();
	/**
	 * list of players.
	 */
	private List<Player> players = new ArrayList<Player>();
	/**
	 * list of magic items.
	 */
	private List<MagicItem> magicitems = new ArrayList<MagicItem>();

	/**
	 * @param o
	 */
	// TODO Java doc
	public Board(TileGenerator<Tile> o) {
		if (o == null) {
			throw new NullPointerException("tile generator is null.");
		}
		List<Tile> tiles = new ArrayList<Tile>();
		tiles = o.getTiles();
		if (tiles.size() != TileGenerator.NUMBER_OF_TILES) {
			throw new IllegalArgumentException();
		}
		generateCorners();
		generateMiddle();
		generateMargins();
		int value = 0;
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {

				if (!(row % 2 == 0 && column % 2 == 0)) {
					fields.add(new Field(tiles.get(value), row, column));
					value++;
				}
			}
		}
		fields.add(new Field(tiles.get(value)));
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
	// TODO Java doc
	private void generateField(int rotations, Tile tile, int row, int column) {
		for (int i = 0; i < rotations; i++) {
			tile.rotateClockwise();
		}
		final Field field = new Field(tile, row, column);
		fields.add(field);
	}

	/**
	 * 
	 */
	// TODO Java doc
	private void generateCorners() {

		for (int i = 0; i < NUMBER_OF_CONERS; i++) {
//			if (i == 0) {
//				generateField(0, new Nook(), SIZE - 1, SIZE - 1);
//			}
//			else if (i == 1) {
//				generateField(1, new Nook(), SIZE - 1, 0);
//			}
//			else if (i == 2) {
//				generateField(2, new Nook(), 0, 0);
//			}
//			else {
//				generateField(3, new Nook(), 0, SIZE - 1);
//			}
			
			switch (i) {
			case 0:
				generateField(i, new Nook(), SIZE - 1, SIZE - 1);
				break;
			case 1:
				generateField(i, new Nook(), SIZE - 1, 0);
				break;
			case 2:
				generateField(i, new Nook(), 0, 0);
				break;
			case NUMBER_OF_CONERS - 1:
				generateField(i, new Nook(), 0, SIZE - 1);
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 
	 */
	// TODO Java doc
	private void generateMiddle() {
		for (int i = 0; i < NUMBER_OF_CONERS; i++) {
			if (i == 0) {
				generateField(0, new Tri(), 2, 4);
			}
			else if (i == 1) {
				generateField(1, new Tri(), 4, 4);
			}
			else if (i == 2) {
				generateField(2, new Tri(), 4, 2);
			}
			else {
				generateField(3, new Tri(), 2, 2);
			}
		}

	}

	/**
	 * 
	 */
	// TODO Java doc
	private void generateMargins() {
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {

				if (column % 2 == 0 && row % 2 == 0) {
					if (row == 0 && !(column == 0 || column == SIZE - 1)) {
						generateField(0, new Tri(), row, column);
					}
					if (column == SIZE - 1 && !(row == 0 || row == SIZE - 1)) {
						generateField(1, new Tri(), row, column);
					}
					if (row == SIZE - 1 && !(column == 0 || column == SIZE - 1)) {
						generateField(2, new Tri(), row, column);

					}
					if (column == 0 && !(row == 0 || row == SIZE - 1)) {
						generateField(3, new Tri(), row, column);
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

	/**
	 * @param row
	 * @param column
	 * @return
	 */
	// TODO Java doc
	public Field getField(int row, int column) {
		for (Field y : fields) {
			if (y.getRow() == row && y.getColumn() == column) {
				return y;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * @return
	 */
	// TODO Java doc
	public Tile getFreeTile() {
		return getField(-1, -1).getTile();
	}

	/**
	 * @param players
	 */
	// TODO Java doc
	public void addPlayers(Player... players) {
		if (players.equals(null)) {
			throw new NullPointerException();
		}
		else if (players.length == 0 || players.length > MAX_PLAYER) {
			throw new IllegalArgumentException();
		}
		else {
			for (Player y : players) {
				switch (y.getColor()) {
				case BLUE:
					getField(2, 2).setPlayer(y);
					break;
				case WHITE:
					getField(2, 4).setPlayer(y);
					break;
				case YELLOW:
					getField(4, 4).setPlayer(y);
					break;
				case RED:
					getField(4, 2).setPlayer(y);
					break;
				default:
					throw new IllegalArgumentException();
					// break;
				}
			}
		}
	}

	/**
	 * @param field
	 * @return
	 */
	public Set<Field> getNeighbors(Field field) {
		TreeSet<Field> fieldTree = new TreeSet<Field>();
		Direction up = Direction.NORTH;
		Direction down = Direction.SOUTH;
		Direction left = Direction.WEST;
		Direction right = Direction.EAST;
		
		if (field.getTile().isConnectedTo(up)) {
			Field north = getField(field.getRow() - 1, field.getColumn());
			if (north.getTile().isConnectedTo(up.getOppositeDirection())) {
				fieldTree.add(north);
			}
		}
		if (field.getTile().isConnectedTo(down)) {
			Field south = getField(field.getRow() - 1, field.getColumn());
			if (south.getTile().isConnectedTo(down.getOppositeDirection())) {
				fieldTree.add(south);
			}
		}
		if (field.getTile().isConnectedTo(left)) {
			Field west = getField(field.getRow(), field.getColumn() - 1);
			if (west.getTile().isConnectedTo(left.getOppositeDirection())) {
				fieldTree.add(west);
			}
		}
		
		if (field.getTile().isConnectedTo(right)) {
			Field east = getField(field.getRow(), field.getColumn() + 1);
			if (east.getTile().isConnectedTo(right.getOppositeDirection())) {
				fieldTree.add(east);
			}

		}
		
		return fieldTree;
	}
	

	/**
	 * Search for the field with the given Player on it.
	 * 
	 * @param wanted
	 *            person
	 * @return the field with the player on it.
	 */
	public Field getFieldWith(Player wanted) {

		for (Field y : fields) {
			if (y.getPlayer().equals(wanted)) {
				return y;
			}
		}
		throw new IllegalArgumentException("Player not found.");
	}

	/**
	 * Search for the lowest magic item value and return it's field.
	 * @return the field with the lowest magic item.
	 */
	public Field getCurrentTargetField() {
		Collections.sort(fields);
		return fields.get(0);
	}

	/**
	 * Return the unmodifiable list fields.
	 * @return the fields
	 */
	public Collection<Field> getFields() {
		return Collections.unmodifiableList(fields);
	}
	
	public Set<Field> reachableSet(Field start) {
		//TODO reachableSet(Field start)
		return (Set<Field>) start;
	}
	
	/**
	 * @param player to move
	 * @param targetField The field, the player walk to.
	 */
	public void movePlayer(Player player, Field targetField){
		getFieldWith(player).setPlayer(null);
		//player adds the new magic item, if some one is on the field
		player.addMagicItemFound(targetField.getMagicItem());
		//takes the magic item away 
		targetField.setMagicItem(null);
		//moves player to his new field.
		targetField.setPlayer(player);
	}

}
