/**
 * 
 */
package edu.hm.labyrinth;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.hm.labyrinth.generator.FixedTileGenerator;
import edu.hm.labyrinth.generator.RandomTileGenerator;
import edu.hm.labyrinth.tile.Tile;

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
		assertEquals(size, random.getTiles().size());
		assertEquals(size, fixed.getTiles().size());

	}

	@Test
	public void testCreateTiles() {
		
		
	}

}
