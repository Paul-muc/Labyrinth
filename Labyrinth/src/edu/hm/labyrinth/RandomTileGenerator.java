package edu.hm.labyrinth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Paul
 *
 */
public class RandomTileGenerator implements TileGenerator {

	/**
	 * 
	 */
	List<Tile> tiles = new ArrayList<Tile>();

	/**
	 * 
	 */
	public RandomTileGenerator() {
		this.tiles = createTieles();
		Collections.shuffle(tiles);
	}

	/* (non-Javadoc)
	 * @see edu.hm.labyrinth.TileGenerator#createTieles()
	 */
	@Override
	public List<Tile> createTieles() {
		int numberOfTris = 5;
		int numberOfStraights = 13;
		int numberOfNooks = 16;
		Tile tile;
		
		for(int i = 0; i<numberOfTris; i++){
			tile = new Tri();
			tile.randomlyRotate();
			tiles.add(tile);
		}
		
		for(int i = 0; i<numberOfStraights; i++){
			tile = new Straight();
			tile.randomlyRotate();
			tiles.add(tile);
		}
		
		for(int i = 0; i<numberOfNooks; i++){
			tile = new Nook();
			tile.randomlyRotate();
			tiles.add(tile);
		}
		return tiles;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RandomTileGenerator [tiles=" + tiles + "]";
	}

}
