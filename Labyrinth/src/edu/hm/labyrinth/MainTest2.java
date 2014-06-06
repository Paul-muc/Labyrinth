package edu.hm.labyrinth;

import edu.hm.labyrinth.generator.FixedTileGenerator;
import edu.hm.labyrinth.generator.RandomTileGenerator;

public class MainTest2 {

	public static void main(String[] args) {
		FixedTileGenerator blubb = new FixedTileGenerator();
		blubb.createTiles();
		System.out.println(blubb.toString());
		System.out.println(blubb.getTiles().size());
		System.out.println();
		RandomTileGenerator blubb2 = new RandomTileGenerator();
		blubb2.createTiles();
		System.out.println(blubb2.toString());
		System.out.println(blubb2.getTiles().size());
	}

}
