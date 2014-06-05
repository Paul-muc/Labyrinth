package edu.hm.labyrinth;

import edu.hm.labyrinth.board.Board;
import edu.hm.labyrinth.generator.FixedTileGenerator;

public class MainTest3 {
	public static void main(String[] args) {

		FixedTileGenerator x = new FixedTileGenerator();
		Board board = new Board(x);
		System.out.println(board.toString());
	}

}
