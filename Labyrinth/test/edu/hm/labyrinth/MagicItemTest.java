package edu.hm.labyrinth;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MagicItemTest {

	MagicItem itemOk;
	MagicItem itemOk2;
	MagicItem itemFail;
	MagicItem itemNegativ;
	
	
	@Before
	public void setUp(){
		
		itemOk = new MagicItem(2);
		itemOk2 = new MagicItem(25);
		itemFail = new MagicItem(21);
		itemNegativ = new MagicItem(-2);
		
	}

	@Test
	public void testGetValue() {

	assertEquals(2, itemOk.getValue());
	assertEquals(25, itemOk2.getValue());
	assertEquals(0, itemFail.getValue());
	assertEquals(0, itemNegativ.getValue());
	
	
	}

}
