package edu.hm.labyrinth;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TileTest {

	Tile nook;
	Tile straight;
	Tile tri;

	@Before
	public void setUp() throws Exception {
		nook = new Nook();
		straight = new Straight();
		tri = new Tri();
	}

	@Test
	public void testIsConnectedTo() {

		// Nook
		assertTrue(nook.isConnectedTo(Direction.NORTH));
		assertTrue(nook.isConnectedTo(Direction.WEST));
		assertFalse(nook.isConnectedTo(Direction.SOUTH));
		assertFalse(nook.isConnectedTo(Direction.EAST));

		// Nook
		assertTrue(straight.isConnectedTo(Direction.NORTH));
		assertTrue(straight.isConnectedTo(Direction.SOUTH));
		assertFalse(straight.isConnectedTo(Direction.WEST));
		assertFalse(straight.isConnectedTo(Direction.EAST));

		// Tri
		assertTrue(tri.isConnectedTo(Direction.EAST));
		assertTrue(tri.isConnectedTo(Direction.WEST));
		assertTrue(tri.isConnectedTo(Direction.SOUTH));
		assertFalse(tri.isConnectedTo(Direction.NORTH));
	}

	@Test
	public void testRotateClockwise() {

		// Nook
		// first rotate
		nook.rotateClockwise();
		assertTrue(nook.isConnectedTo(Direction.NORTH));
		assertTrue(nook.isConnectedTo(Direction.EAST));
		assertFalse(nook.isConnectedTo(Direction.WEST));
		assertFalse(nook.isConnectedTo(Direction.SOUTH));
		// second rotate
		nook.rotateClockwise();
		assertTrue(nook.isConnectedTo(Direction.EAST));
		assertTrue(nook.isConnectedTo(Direction.SOUTH));
		assertFalse(nook.isConnectedTo(Direction.NORTH));
		assertFalse(nook.isConnectedTo(Direction.WEST));
		// third rotate
		nook.rotateClockwise();
		assertTrue(nook.isConnectedTo(Direction.SOUTH));
		assertTrue(nook.isConnectedTo(Direction.WEST));
		assertFalse(nook.isConnectedTo(Direction.NORTH));
		assertFalse(nook.isConnectedTo(Direction.EAST));

		// Straight
		// first rotate
		straight.rotateClockwise();
		assertTrue(straight.isConnectedTo(Direction.EAST));
		assertTrue(straight.isConnectedTo(Direction.WEST));
		assertFalse(straight.isConnectedTo(Direction.NORTH));
		assertFalse(straight.isConnectedTo(Direction.SOUTH));
		// second rotate
		straight.rotateClockwise();
		assertTrue(straight.isConnectedTo(Direction.NORTH));
		assertTrue(straight.isConnectedTo(Direction.SOUTH));
		assertFalse(straight.isConnectedTo(Direction.WEST));
		assertFalse(straight.isConnectedTo(Direction.EAST));

		// Tri
		// first rotate
		tri.rotateClockwise();
		assertTrue(tri.isConnectedTo(Direction.NORTH));
		assertTrue(tri.isConnectedTo(Direction.SOUTH));
		assertTrue(tri.isConnectedTo(Direction.WEST));
		assertFalse(tri.isConnectedTo(Direction.EAST));
		// second rotate
		tri.rotateClockwise();
		assertTrue(tri.isConnectedTo(Direction.EAST));
		assertTrue(tri.isConnectedTo(Direction.NORTH));
		assertTrue(tri.isConnectedTo(Direction.WEST));
		assertFalse(tri.isConnectedTo(Direction.SOUTH));
		// third rotate
		tri.rotateClockwise();
		assertTrue(tri.isConnectedTo(Direction.NORTH));
		assertTrue(tri.isConnectedTo(Direction.SOUTH));
		assertTrue(tri.isConnectedTo(Direction.EAST));
		assertFalse(tri.isConnectedTo(Direction.WEST));

	}

}
