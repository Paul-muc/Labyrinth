package edu.hm.labyrinth;

import edu.hm.labyrinth.tile.Tile;
import edu.hm.labyrinth.tile.Tri;

public class probs {

	public static void main(String[] args) {


		Tile tri = new Tri();
		System.out.println(tri);
		System.out.println();
		tri.rotateClockwise();
		System.out.println(tri);
		System.out.println();
		tri.rotateClockwise();
		System.out.println(tri);
		
		
	}

}
