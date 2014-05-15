package schreiber.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest {

	@Test
	public void getSetSquareTest() {
		TicTacToeBoard game = new TicTacToeBoard();
		game.setSquare(new Location(0, 1), Symbol.X);
		Symbol code1 = game.getSquare(new Location(0, 1));
		Assert.assertEquals(Symbol.X, code1);

		Symbol code2 = game.getSquare(new Location(0, 0));
		Assert.assertNull(code2);
	}

	@Test
	public void isFullTest() {
		TicTacToeBoard game = new TicTacToeBoard();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				game.setSquare(new Location(i, j), Symbol.O);
			}
		}
		Assert.assertTrue(game.isFull());
	}

	@Test
	public void resetTest() {
		TicTacToeBoard game = new TicTacToeBoard();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				game.setSquare(new Location(i, j), Symbol.O);
			}
		}
		game.reset();
		boolean success = true;
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				if (game.getSquare(new Location(a, b)) != null) {
					success = false;
				}
			}
		}
		Assert.assertTrue(success);

	}

}
