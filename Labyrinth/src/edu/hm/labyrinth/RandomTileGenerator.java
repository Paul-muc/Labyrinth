package edu.hm.labyrinth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the random tile generator with an ArrayList of tiles.
 * 
 * @author Paul Seer
 *
 */
public class RandomTileGenerator implements TileGenerator {

	/**
	 * A ArrayList of tiles.
	 */
	List<Tile> tiles = new ArrayList<Tile>();

	/**
	 * Constructs a random ArrayList of tiles.
	 */
	public RandomTileGenerator() {
		this.tiles = createTiles();
		Collections.shuffle(tiles);
	}

	/* (non-Javadoc)
	 * @see edu.hm.labyrinth.TileGenerator#createTieles()
	 */
	@Override
	public List<Tile> createTiles() {
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
