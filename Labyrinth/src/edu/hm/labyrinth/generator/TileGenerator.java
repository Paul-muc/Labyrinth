package edu.hm.labyrinth.generator;

import java.util.List;

import edu.hm.labyrinth.tile.Tile;

/**
 * Represents the interface to generate tiles.
 * @author Paul Seer
 *
 */
public interface TileGenerator {

	/**
	 * Standard numbers of tiles is {@value #NUMBER_OF_TILES}.
	 */
	int NUMBER_OF_TILES = 34;
	/**
	 * Create new tiles.
	 *
	 * @return a list of tiles.
	 */
	List<Tile> createTiles();

}
