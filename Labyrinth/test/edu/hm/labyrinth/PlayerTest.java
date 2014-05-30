package edu.hm.labyrinth;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	Player player;
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
		player = new Player(color);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
