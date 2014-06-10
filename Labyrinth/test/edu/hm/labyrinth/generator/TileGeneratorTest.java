/**
 * 
 */
package edu.hm.labyrinth.generator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.hm.labyrinth.generator.FixedTileGenerator;
import edu.hm.labyrinth.generator.RandomTileGenerator;
import edu.hm.labyrinth.tile.Tile;
import edu.hm.labyrinth.tile.Tri;

/**
 * @author Paul Seer
 * 
 */
public class TileGeneratorTest {

	RandomTileGenerator random;
	FixedTileGenerator fixed;
	List<Tile> tilesRandom = new ArrayList<Tile>();
	List<Tile> tilesFiexed = new ArrayList<Tile>();
	Tile numberOfRotatesZero;
	Tile numberOfRotatesOne;
	Tile numberOfRotatesTwo;
	Tile numberOfrotatesThree;
	@Before
	public void setUp() {
		random = new RandomTileGenerator();
		fixed = new FixedTileGenerator();
		numberOfRotatesZero = new Tri();
		//einmal gedreht
		numberOfRotatesOne = new Tri();
		numberOfRotatesOne.rotateClockwise();
		//zweimal gedreht
		numberOfRotatesTwo = new Tri();
		numberOfrotatesThree = new Tri();
		for(int i = 0; i<2; i++){
			numberOfRotatesTwo.rotateClockwise();
			numberOfrotatesThree.rotateClockwise();
		}
		numberOfrotatesThree.rotateClockwise();
	}

	@Test
	public void testSize() {

		int size = 34;
		assertEquals(size, random.getTiles().size());
		assertEquals(size, fixed.getTiles().size());

	}

	@Test
	public void testCreateTiles() {
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		tiles.add(numberOfRotatesZero);
		tiles.add(numberOfRotatesOne);
		tiles.add(numberOfRotatesTwo);
		tiles.add(numberOfrotatesThree);
		for(int i = 0; i<fixed.getTiles().size(); i++){
		assertTrue(tiles.get(i%4).equals(fixed.getTiles().get(i)));
		}
	}
}
