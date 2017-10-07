package cv_2;

import game.Game;
import game.player.Human;
import game.player.StupidPlayer;

/**
 *
 * @author lukstankovic
 */
public class Cv_2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Human player1 = new Human("Pepa");
		Human player2 = new Human("Fero");
		Game game = new Game(3, player1, player2);
		game.playGame();
	}

}
