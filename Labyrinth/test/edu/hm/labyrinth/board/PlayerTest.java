package edu.hm.labyrinth.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.hm.labyrinth.board.Color;
import edu.hm.labyrinth.board.MagicItem;
import edu.hm.labyrinth.board.Player;

public class PlayerTest {

	Player playerBlue;
	Player playerWhite;
	Player playerRed;
	Player playerYellow;
	
	MagicItem magicItem1;
	MagicItem magicItem2;
	MagicItem magicItem3;
	Color color;
	
	@Before
	public void setUp() throws Exception {
		color = Color.BLUE;
		magicItem1 = new MagicItem(1);
		magicItem2 = new MagicItem(20);
		magicItem3 = new MagicItem(25);
		playerBlue = new Player(color);
		playerWhite = new Player(Color.WHITE);
		playerRed = new Player(Color.RED);
		playerYellow = new Player(Color.YELLOW);
	}

	@Test
	public void testReduceMagicWands() {

		assertEquals(3, playerBlue.getMagicWands());
		assertTrue(playerBlue.reduceMagicWands());
		assertEquals(2, playerBlue.getMagicWands());
		assertTrue(playerBlue.reduceMagicWands());
		assertEquals(1, playerBlue.getMagicWands());
		assertTrue(playerBlue.reduceMagicWands());
		assertEquals(0, playerBlue.getMagicWands());
		assertFalse(playerBlue.reduceMagicWands());
		assertEquals(0, playerBlue.getMagicWands());
	}
	
	
	@Test
	public void testGetPoints(){
		assertEquals(6, playerBlue.getPoints());
		//+1
		playerBlue.addMagicItemFound(magicItem1);
		assertEquals(7, playerBlue.getPoints());
		//+20
		playerBlue.addMagicItemFound(magicItem2);
		assertEquals(27, playerBlue.getPoints());
		//+25
		playerBlue.addMagicItemFound(magicItem3);
		assertEquals(52, playerBlue.getPoints());
		
	}
	
	public void testGetColor(){
		assertEquals(Color.BLUE, playerBlue.getColor());
		assertEquals(Color.WHITE, playerWhite.getColor());
		assertEquals(Color.RED, playerRed.getColor());
		assertEquals(Color.YELLOW, playerYellow.getColor());
		
	}
}
