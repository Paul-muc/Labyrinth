package edu.hm.labyrinth.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.hm.labyrinth.board.MagicItem;

public class MagicItemTest {

	MagicItem itemOk;
	MagicItem itemOk2;
	MagicItem itemFail;
	MagicItem itemNegativ;

	@Before
	public void setUp() {

		itemOk = new MagicItem(2);
		itemOk2 = new MagicItem(25);

	}

	@Test
	public void testGetValue() {
		assertEquals(2, itemOk.getValue());
		assertEquals(25, itemOk2.getValue());
	}

	@Test
	public void setUpWithException() {

		try {
			itemFail = new MagicItem(21);
		} catch (NullPointerException e) {
			assertTrue(true);
		}

		try {
			itemNegativ = new MagicItem(-2);
		} catch (NullPointerException e) {
			assertTrue(true);
		}

	}

}
