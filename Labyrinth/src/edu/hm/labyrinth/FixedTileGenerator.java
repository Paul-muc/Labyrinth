package edu.hm.labyrinth;

import java.util.ArrayList;
import java.util.List;

/**
* Represents a fixed tile generator with an ArrayList of tiles.
 * 
 * @author Paul Seer
 *
 */
public class FixedTileGenerator implements TileGenerator{


	/**
	 * A ArrayList of tiles.
	 */
	List<Tile> tiles = new ArrayList<Tile>();
	
	/**
	 * Constructs a fixed ArrayList of tiles.
	 */
	public FixedTileGenerator() {
		this.tiles = createTiles();
	}
	
	/* (non-Javadoc)
	 * @see edu.hm.labyrinth.TileGenerator#createTieles()
	 */
	@Override
	public List<Tile> createTiles() {

		for(int i = 0; i<TileGenerator.NUMBER_OF_TILES; i++){
			Tile tri = new Tri();
			for(int y = i%4; y>0; y--){
				tri.rotateClockwise();
			}
			tiles.add(tri);
		}

		return tiles;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FixedTileGenerator [tiles=" + tiles + "]";
	}

}
