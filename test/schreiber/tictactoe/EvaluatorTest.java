package schreiber.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {

	@Test
	public void testWinner() throws Exception {
		TicTacToeBoard game = new TicTacToeBoard();

		game.setSquare(new Location(0, 0), Symbol.X);
		game.setSquare(new Location(0, 1), Symbol.X);
		game.setSquare(new Location(0, 2), Symbol.X);

		Evaluator evaluator = new Evaluator(game);
		evaluator.evaluate();
		Assert.assertEquals(Symbol.X, evaluator.getWinner());

		Assert.assertEquals(0, evaluator.getWinningSquares().get(0).getX());
		Assert.assertEquals(0, evaluator.getWinningSquares().get(0).getY());
		Assert.assertEquals(0, evaluator.getWinningSquares().get(1).getX());
		Assert.assertEquals(1, evaluator.getWinningSquares().get(1).getY());
		Assert.assertEquals(0, evaluator.getWinningSquares().get(2).getX());
		Assert.assertEquals(2, evaluator.getWinningSquares().get(2).getY());
	}

	@Test
	public void testNull() throws Exception {
		TicTacToeBoard game = new TicTacToeBoard();
		Evaluator evaluator = new Evaluator(game);
		evaluator.evaluate();
		Assert.assertEquals(null, evaluator.getWinner());
	}

	@Test
	public void testThreeInRow() throws Exception {
		TicTacToeBoard game = new TicTacToeBoard();

		game.setSquare(new Location(0, 0), Symbol.X);
		game.setSquare(new Location(0, 1), Symbol.X);
		game.setSquare(new Location(0, 2), Symbol.X);

		Evaluator evaluator = new Evaluator(game);
		evaluator.evaluate();
		Assert.assertEquals(Symbol.X, evaluator.getWinner());

		game.reset();
		game.setSquare(new Location(1, 0), Symbol.X);
		game.setSquare(new Location(1, 1), Symbol.X);
		game.setSquare(new Location(1, 2), Symbol.X);

		evaluator.evaluate();
		Assert.assertEquals(Symbol.X, evaluator.getWinner());

		game.reset();
		game.setSquare(new Location(2, 0), Symbol.X);
		game.setSquare(new Location(2, 1), Symbol.X);
		game.setSquare(new Location(2, 2), Symbol.X);

		evaluator.evaluate();
		Assert.assertEquals(Symbol.X, evaluator.getWinner());
	}

	@Test
	public void testThreeInColumn() throws Exception {
		TicTacToeBoard game = new TicTacToeBoard();

		game.setSquare(new Location(0, 0), Symbol.X);
		game.setSquare(new Location(1, 0), Symbol.X);
		game.setSquare(new Location(2, 0), Symbol.X);

		Evaluator evaluator = new Evaluator(game);
		evaluator.evaluate();
		Assert.assertEquals(Symbol.X, evaluator.getWinner());

		game.reset();
		game.setSquare(new Location(0, 1), Symbol.X);
		game.setSquare(new Location(1, 1), Symbol.X);
		game.setSquare(new Location(2, 1), Symbol.X);

		evaluator.evaluate();
		Assert.assertEquals(Symbol.X, evaluator.getWinner());

		game.reset();
		game.setSquare(new Location(0, 2), Symbol.X);
		game.setSquare(new Location(1, 2), Symbol.X);
		game.setSquare(new Location(2, 2), Symbol.X);

		evaluator.evaluate();
		Assert.assertEquals(Symbol.X, evaluator.getWinner());
	}

	@Test
	public void testDiagonal() throws Exception {
		TicTacToeBoard game = new TicTacToeBoard();

		game.setSquare(new Location(0, 0), Symbol.X);
		game.setSquare(new Location(1, 1), Symbol.X);
		game.setSquare(new Location(2, 2), Symbol.X);

		Evaluator evaluator = new Evaluator(game);
		evaluator.evaluate();
		Assert.assertEquals(Symbol.X, evaluator.getWinner());

		game.reset();
		game.setSquare(new Location(0, 2), Symbol.X);
		game.setSquare(new Location(1, 1), Symbol.X);
		game.setSquare(new Location(2, 0), Symbol.X);

		evaluator.evaluate();
		Assert.assertEquals(Symbol.X, evaluator.getWinner());
	}

	@Test
	public void testNoWinnerOnEmptyBoard() {
		TicTacToeBoard emptyBoard = new TicTacToeBoard();
		Evaluator evaluator = new Evaluator(emptyBoard);
		evaluator.evaluate();
		Assert.assertNull(evaluator.getWinner());
		Assert.assertNull(evaluator.getWinningSquares());
	}

	@Test
	public void testNoWinnerOnFullBoard() {
		TicTacToeBoard game = new TicTacToeBoard();
		game.setSquare(new Location(0, 0), Symbol.X);
		game.setSquare(new Location(0, 1), Symbol.O);
		game.setSquare(new Location(0, 2), Symbol.X);
		game.setSquare(new Location(1, 0), Symbol.X);
		game.setSquare(new Location(1, 1), Symbol.O);
		game.setSquare(new Location(1, 2), Symbol.X);
		game.setSquare(new Location(2, 0), Symbol.O);
		game.setSquare(new Location(2, 1), Symbol.X);
		game.setSquare(new Location(2, 2), Symbol.O);

		Evaluator evaluator = new Evaluator(game);
		evaluator.evaluate();

		Assert.assertNull(evaluator.getWinner());
		Assert.assertNull(evaluator.getWinningSquares());
	}

}
