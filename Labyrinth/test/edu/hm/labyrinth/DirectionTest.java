package edu.hm.labyrinth;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DirectionTest {

	Direction north;
	Direction east;
	Direction south;
	Direction west;

	@Before
	public void setUp() throws Exception {
		north = Direction.NORTH;
		east = Direction.EAST;
		south = Direction.SOUTH;
		west = Direction.WEST;
	}

	@Test
	public void testGetOppositeDirection() {
		assertEquals(Direction.SOUTH, north.getOppositeDirection());
		assertEquals(Direction.WEST, east.getOppositeDirection());
		assertEquals(Direction.NORTH, south.getOppositeDirection());
		assertEquals(Direction.EAST, west.getOppositeDirection());

	}

	@Test
	public void testValues() {
		Direction[] values = new Direction[] { Direction.NORTH, Direction.EAST,
				Direction.SOUTH, Direction.WEST };
		Direction[] directions = Direction.values();
		for(int i=0; i<values.length; i++){
			assertEquals(values[i], directions[i]);
		}
		
		assertArrayEquals(values, Direction.values());
	}
}
