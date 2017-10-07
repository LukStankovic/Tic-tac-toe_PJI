/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.player;

import game.board.Board;
import game.board.BoardSymbol;
import java.util.Random;

/**
 *
 * @author lukstankovic
 */
public class StupidPlayer implements IMove {
	private final String name;

	public StupidPlayer(String name) {
		this.name = name;
	}
	
	@Override
	public Move makeMove(Board board, BoardSymbol yourSymbol) {
		int posX, posY;
		Random rand = new Random();
		do {
			posX = rand.nextInt(board.getBoardSize());
			posY = rand.nextInt(board.getBoardSize());
		} while (board.getSymbolAtPosition(posX, posY) != null);
		return new Move(posX, posY, yourSymbol);
	}

	@Override
	public String getName() {
		return name;
	}
	
}
