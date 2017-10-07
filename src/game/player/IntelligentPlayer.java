/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.player;

import game.board.Board;
import game.board.BoardSymbol;

/**
 *
 * @author lukstankovic
 */
public class IntelligentPlayer implements IMove {
	private final String name;

	public IntelligentPlayer(String name) {
		this.name = name;
	}
	
	@Override
	public Move makeMove(Board board, BoardSymbol yourSymbol) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	@Override
	public String getName() {
		return name;
	}

}
