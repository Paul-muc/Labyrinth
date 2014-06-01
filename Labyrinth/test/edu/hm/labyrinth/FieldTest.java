package edu.hm.labyrinth;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {
	
	Field fieldSmallMI;
	Field fieldHugeMI;
	Field fieldWithoutMI;
	Player playerOne;
	Player playerTwo;
	MagicItem magicItemOne;
	MagicItem magicItemTwo;
	Nook nook;
	Straight straight;
	Tri tri;
	Tri secondTri;

	@Before
	public void setUp() throws Exception {
		playerOne = new Player(Color.BLUE);
		playerTwo = new Player(Color.RED);
		nook = new Nook();
		tri = new Tri();
		secondTri = new Tri();
		straight = new Straight();
		magicItemOne = new MagicItem(1);
		magicItemTwo = new MagicItem(25);
		fieldWithoutMI = new Field(nook);
		fieldSmallMI = new Field(straight, 0, 0);
		fieldHugeMI = new Field(tri, 1, 1);
	}

	@Test
	public void testSetMagicItem() {

		fieldSmallMI.setMagicItem(magicItemOne);
		fieldHugeMI.setMagicItem(magicItemTwo);
		
		assertEquals(magicItemOne, fieldSmallMI.getMagicItem());
		assertEquals(magicItemTwo, fieldHugeMI.getMagicItem());
		
	}
	
	@Test
	public void testSetPlayer(){
		fieldSmallMI.setPlayer(playerOne);
		fieldHugeMI.setPlayer(playerTwo);
		
		assertEquals(playerOne, fieldSmallMI.getPlayer());
		assertEquals(playerTwo, fieldHugeMI.getPlayer());
	}
	@Test
	public void testSetTile(){
		assertEquals(straight, fieldSmallMI.getTile());
		fieldSmallMI.setTile(secondTri);
		assertEquals(secondTri, fieldSmallMI.getTile());
	}
	
	@Test
	public void testCompareTo(){
		fieldSmallMI.setMagicItem(magicItemOne);
		fieldHugeMI.setMagicItem(magicItemTwo);
		
		ArrayList<Field> field = new ArrayList<Field>();
		field.add(fieldSmallMI);
		field.add(fieldHugeMI);
		field.add(fieldWithoutMI);
		//sort
		Collections.sort(field);
		
		assertEquals(fieldWithoutMI, field.get(0));
		assertEquals(fieldSmallMI, field.get(1));
		assertEquals(fieldHugeMI, field.get(2));
		
	}
	

}
