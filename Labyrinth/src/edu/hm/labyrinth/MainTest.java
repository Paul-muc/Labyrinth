package edu.hm.labyrinth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

import edu.hm.labyrinth.board.Field;
import edu.hm.labyrinth.board.MagicItem;
import edu.hm.labyrinth.generator.FixedTileGenerator;
import edu.hm.labyrinth.tile.Direction;
import edu.hm.labyrinth.tile.Nook;
import edu.hm.labyrinth.tile.Straight;
import edu.hm.labyrinth.tile.Tile;
import edu.hm.labyrinth.tile.Tri;

public class MainTest
{

	public static void main(String[] args)
	{
		Direction[] directions = Direction.values();
//		for(Direction x: directions){
//			System.out.println(x);
//		}
//		System.out.println();
//		for(Direction x: directions){
//			System.out.println(x.getOppositeDirection());
//		}
//		Direction testDirection = Direction.NORTH;
//		
//		System.out.println(Direction.valueOf(directions[2].toString()));
		Tile tri = new Tri();
		Tile straight = new Straight();
		Tile nook = new Nook();
		
//		tri.randomlyRotate();
//		tri.randomlyRotate();
//		tri.randomlyRotate();
//		tri.randomlyRotate();
//		tri.randomlyRotate();
//		tri.randomlyRotate();
//		tri.randomlyRotate();
//		tri.randomlyRotate();
//		tri.randomlyRotate();
//		tri.randomlyRotate();
//		tri.randomlyRotate();
//		tri.randomlyRotate();
//		tri.randomlyRotate();
		
		
//		System.out.println(blubb.toString());
//		System.out.println();
//		blubb.rotateClockwise();
//		System.out.println(blubb.toString());
//		System.out.println();
//		blubb.randomlyRotate();
//		System.out.println();
//		System.out.println(blubb.toString());
//		MagicItem bla = new MagicItem(2);
//		System.out.println(bla.toString());
	
		MagicItem m1 = new MagicItem(25);
		MagicItem m2 = new MagicItem(1);
		MagicItem m3 = new MagicItem(2);
		
		Field field1 = new Field(nook, 1, 1);
		field1.setMagicItem(m3);
		
		Field field2 = new Field(straight, 1, 2);
		field2.setMagicItem(m2);
		
		Field field3 = new Field(tri, 2, 1);
		field3.setMagicItem(m1);
		
		Field field4 = new Field(straight, 2, 2);
		
		ArrayList<Field> field = new ArrayList<Field>();
		field.add(field1);
		field.add(field2);
		field.add(new Field(nook));
		field.add(field3);
		field.add(field4);
		
		for(Field y: field){
			System.out.println(y.toString());
		}
		
		Collections.sort(field);
		System.out.println();
		
		for(Field y: field){
			System.out.println(y.toString());
		}
		
		FixedTileGenerator blubb = new FixedTileGenerator();
		System.out.println(blubb.toString());
	}

}
