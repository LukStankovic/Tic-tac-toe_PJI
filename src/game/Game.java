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
		for (int round = 0;;) {
			System.out.println(board);
			Move move1 = player1.makeMove(board, BoardSymbol.CROSS);
			board.setSymbolAccordingToMove(move1);
			if (isWinner(board, move1)) {
				System.out.println(player1.getName() + " won!");
				System.out.println(board);
				return;
			}
			round++;
			if (round == board.getBoardSize() * board.getBoardSize()) {
				break;
			}
			
			System.out.println(board);
			Move move2 = player2.makeMove(board, BoardSymbol.CIRCLE);
			board.setSymbolAccordingToMove(move2);
			if (isWinner(board, move2)) {
				System.out.println(player2.getName() + " won!");
				System.out.println(board);
				return;
			}
			round++;
			if (round == board.getBoardSize() * board.getBoardSize()) {
				break;
			}
		}
		System.out.println("It`s a draw!");
	}

	//todo doma + vytvořit novou třídu inteligentní hráč, který bude implementovat IMove
	private boolean isWinner(Board board, Move move) {

		if (this.checkColumns(board, move)) {
			return true;
		}

		if (this.checkRows(board, move)) {
			return true;
		}

		if (this.checkDiagonals(board, move)) {
			return true;
		}
		
		return this.checkLeftToRightDiagonals(board, move);
	}

	private boolean checkColumns(Board board, Move move) {
		for (int i = 0; i < board.getSymbolsToWin(); i++) {
			if (board.getSymbolAtPosition(move.getPositionX(), i) != move.getSymbol()) {
				break;
			}
			if (i == board.getSymbolsToWin() - 1) {
				return true;
			}
		}
		
		return false;
	}

	private boolean checkRows(Board board, Move move) {
		for (int i = 0; i < board.getSymbolsToWin(); i++) {
			if (board.getSymbolAtPosition(i, move.getPositionY()) != move.getSymbol()) {
				break;
			}
			if (i == board.getSymbolsToWin() - 1) {
				return true;
			}
		}
		
		return false;
	}

	private boolean checkLeftToRightDiagonals(Board board, Move move) {
		int count = 0;
		int diagonalCount = 2 * board.getBoardSize();
		
		for (int i = 0; i < diagonalCount - 1; i++) {
			int posX = i < board.getBoardSize() ? 0 : i - board.getBoardSize() + 1;
			for (int j = posX; j <= i - posX; j++) {
				if (board.getSymbolAtPosition(j, i - j) != move.getSymbol()) {
					count = 0;
					break;
				}
				if (count == board.getSymbolsToWin() - 1) {
					return true;
				}
				count++;
			}
			count = 0;
		}
		
		return false;
	}

	private boolean checkDiagonals(Board board, Move move) {
		int count = 0;
		
		for (int j = board.getBoardSize() - 1; j >= 0; j--) {
			for (int k = 0; k < board.getBoardSize(); k++) {
				if ((j + k) < board.getBoardSize()) {
					if (board.getSymbolAtPosition(k, j + k) != move.getSymbol()) {
						count = 0;
						break;
					}
					if (count == board.getSymbolsToWin() - 1) {
						return true;
					}
					count++;
				} else {
					break;
				}
			}
			count = 0;
		}
		
		count = 0;
		
		for (int i = 1; i < board.getBoardSize(); i++) {
			for (int j = i, k = 0; j < board.getBoardSize() && k < board.getBoardSize(); j++, k++) {
				if (board.getSymbolAtPosition(j, k) != move.getSymbol()) {
					count = 0;
					break;
				}
				if (count == board.getSymbolsToWin() - 1) {
					return true;
				}
				count++;
			}
			count = 0;
		}
		
		return false;
	}

}
