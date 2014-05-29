package edu.hm.labyrinth;

public class MainTest2 {

	public static void main(String[] args) {
		FixedTileGenerator blubb = new FixedTileGenerator();
		System.out.println(blubb.toString());
		System.out.println(blubb.tiles.size());
		System.out.println();
		RandomTileGenerator blubb2 = new RandomTileGenerator();
		System.out.println(blubb2.toString());
		System.out.println(blubb2.tiles.size());
	}

}
