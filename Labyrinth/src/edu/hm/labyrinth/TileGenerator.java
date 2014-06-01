package edu.hm.labyrinth;

import java.util.List;

/**
 * Represents the interface to generate tiles.
 * @author Paul Seer
 *
 */
public interface TileGenerator {
	
	/**
	 * Standard numbers of tiles is {@value #NUMBER_OF_TILES}.
	 */
	public final static int NUMBER_OF_TILES = 34;
	/**
	 * Create new tiles.
	 * 
	 * @return a list of tiles.
	 */
	public List<Tile> createTiles();

}
