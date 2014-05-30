package edu.hm.labyrinth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paul Seer
 *
 */
public class FixedTileGenerator implements TileGenerator{


	/**
	 * 
	 */
	List<Tile> tiles = new ArrayList<Tile>();
	/**
	 * 
	 */
	public FixedTileGenerator() {
		this.tiles = createTieles();
	}
	
	/* (non-Javadoc)
	 * @see edu.hm.labyrinth.TileGenerator#createTieles()
	 */
	@Override
	public List<Tile> createTieles() {

		for(int i = 1; i<=TileGenerator.NUMBER_OF_TILES; i++){
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
