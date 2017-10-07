/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.player;

import game.board.Board;
import game.board.BoardSymbol;
import java.util.Scanner;

/**
 *
 * @author lukstankovic
 */
public class Human implements IMove {

	private String name;

	public Human(String name) {
		this.name = name;
	}
	
	@Override
	public Move makeMove(Board board, BoardSymbol yourSymbol) {
		int posX, posY;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter the cooardinates of your move (" + yourSymbol + ")");
			posX = sc.nextInt();
			posY = sc.nextInt();
		} while (board.getSymbolAtPosition(posX, posY) != null);
		return new Move(posX, posY, yourSymbol);
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}
