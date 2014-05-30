package edu.hm.labyrinth;

import java.util.List;

/**
 * @author Paul Seer
 *
 */
public interface TileGenerator {
	
	/**
	 * 
	 */
	public final static int NUMBER_OF_TILES = 34;
	/**
	 * @return
	 */
	public List<Tile> createTieles();

}
