/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.board.Board;
import game.board.BoardSymbol;
import game.player.IMove;
import game.player.Move;

/**
 *
 * @author lukstankovic
 */
public class Game {
	private Board board;
	private IMove player1;
	private IMove player2;

	public Game(int boardSize, IMove player1, IMove player2) {
		this.board = new Board(boardSize);
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void playGame() {
		for (;;) {
			System.out.println(board);
			Move move1 = player1.makeMove(board, BoardSymbol.CROSS);
			board.setSymbolAccordingToMove(move1);
			if (isWinner(board, move1, player1)) {
				return;
			}
			
			System.out.println(board);
			Move move2 = player2.makeMove(board, BoardSymbol.CIRCLE);
			board.setSymbolAccordingToMove(move2);
			if (isWinner(board, move2, player2)) {
				return;
			}
		}
	}
	
	//todo doma + vytvořit novou třídu inteligentní hráč, který bude implementovat IMove
	private boolean isWinner(Board board, Move move1, IMove player1) {
		return false;
	}
	
}
