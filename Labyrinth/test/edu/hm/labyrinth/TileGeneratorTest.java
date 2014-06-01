/**
 * 
 */
package edu.hm.labyrinth;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Paul Seer
 * 
 */
public class TileGeneratorTest {

	RandomTileGenerator random;
	FixedTileGenerator fixed;
	List<Tile> tilesRandom = new ArrayList<Tile>();
	List<Tile> tilesFiexed = new ArrayList<Tile>();

	@Before
	public void setUp() {
		random = new RandomTileGenerator();
		fixed = new FixedTileGenerator();
	}

	@Test
	public void testSize() {

		int size = 34;
		assertEquals(size, random.tiles.size());
		assertEquals(size, fixed.tiles.size());

	}

	@Test
	public void testCreateTiles() {
		
		
	}

}
