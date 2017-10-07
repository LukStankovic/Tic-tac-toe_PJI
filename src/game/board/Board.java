/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.board;

import game.player.Move;

/**
 *
 * @author lukstankovic
 */
public class Board {
	private final int boardSize;
	private final int symbolsToWin;
			
	private BoardSymbol[][] board;
	
	/**
	 * 
	 * @param boardSize
	 * @param symbolsToWin 
	 */
	public Board(int boardSize, int symbolsToWin) {
		this.boardSize = boardSize;
		this.symbolsToWin = symbolsToWin;
		board = new BoardSymbol[boardSize][boardSize];
	}

	public int getBoardSize() {
		return boardSize;
	}

	public int getSymbolsToWin() {
		return symbolsToWin;
	}

	public BoardSymbol getSymbolAtPosition(int x, int y) {
		return board[x][y];
	}
	
	public void setSymbolAccordingToMove(Move move) {
		if (board[move.getPositionX()][move.getPositionY()] == null) {
			board[move.getPositionX()][move.getPositionY()] = move.getSymbol();
		} else {
			System.err.println("There is already a symbol.");
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (board[j][i] == BoardSymbol.CIRCLE) {
					sb.append('O');
				} else if (board[j][i] == BoardSymbol.CROSS) {
					sb.append('X');
				} else {
					sb.append('.');
				}
			}
			sb.append('\n');
		}
		return sb.toString();
	}
	
	
	
	
}
