package schreiber.checkers;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest {

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n"
				+ "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n"
				+ "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that isOnBoard() returns the correct result for different xs and ys
	 */
	public void testIsOnBoard() {
		CheckerBoard board = new CheckerBoard();
		int x;
		int y;
		for (x = -1; x < 9; x++) {
			for (y = -1; y < 9; y++) {
				if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
					Assert.assertTrue(board.isOnBoard(x, y));
				} else {
					Assert.assertFalse(board.isOnBoard(x, y));
				}
			}
		}
	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after setPiece() is called
	 */
	public void testIsEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 1, Piece.WHITE_MAN);
		Assert.assertFalse(board.isEmptySquare(0, 1));
		Assert.assertTrue(board.isEmptySquare(0, 0));
	}

	@Test
	/**
	 * Given an board with pieces, test that calling clear() clears the board
	 */
	public void testClear() {
		final CheckerBoard board = new CheckerBoard();
		board.clear();
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				Assert.assertNull(board.getPiece(y, x));
			}
		}
	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame() {
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(1, 0));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(3, 0));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(5, 0));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(7, 0));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(0, 1));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(2, 1));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(4, 1));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(6, 1));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(1, 2));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(3, 2));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(5, 2));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(7, 2));

		Assert.assertEquals(Piece.RED_MAN, board.getPiece(0, 5));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(2, 5));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(4, 5));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(6, 5));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(1, 6));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(3, 6));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(5, 6));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(7, 6));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(0, 7));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(2, 7));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(4, 7));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(6, 7));
	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 1, Piece.WHITE_MAN);
		Move move = new Move(2, 1, 3, 2);
		board.execute(move);
		Assert.assertNull(board.getPiece(2, 1));
		Assert.assertEquals(board.getPiece(3, 2), Piece.WHITE_MAN);
	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to the 8th row
	 */
	public void testMovePromoteToWhiteKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(6, 5, Piece.WHITE_MAN);
		Move move = new Move(6, 5, 7, 6);
		board.execute(move);
		Assert.assertEquals(board.getPiece(7, 6), Piece.WHITE_KING);
	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testMovePromoteToRedKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 2, Piece.RED_MAN);
		Move move = new Move(1, 2, 0, 3);
		board.execute(move);
		Assert.assertEquals(board.getPiece(0, 3), Piece.RED_KING);
	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes the piece that was jumped
	 */
	public void testJump() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 1, Piece.WHITE_MAN);
		Jump jump = new Jump(2, 1, 3, 2, 4, 3);
		board.execute(jump);
		Assert.assertNull(board.getPiece(2, 1));
		Assert.assertNull(board.getPiece(3, 2));
		Assert.assertEquals(board.getPiece(4, 3), Piece.WHITE_MAN);
	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testJumpPromoteToRedKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 1, Piece.RED_MAN);
		Jump jump = new Jump(2, 1, 1, 2, 0, 3);
		board.execute(jump);
		Assert.assertEquals(board.getPiece(0, 3), Piece.RED_KING);
	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to the 1st row
	 */
	public void testJumpPromoteToWhiteKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 6, Piece.WHITE_MAN);
		Jump jump = new Jump(5, 6, 6, 7, 7, 4);
		board.execute(jump);
		Assert.assertEquals(board.getPiece(7, 4), Piece.WHITE_KING);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when called on an empty square
	 */
	public void testGetMovesForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 0, null);
		List<Move> moves = board.getMoves(1, 0);
		Assert.assertNotNull(moves);
		Assert.assertTrue(moves.size() == 0);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(3, 6, Piece.RED_MAN);
		List<Move> moves = board.getMoves(3, 6);
		Assert.assertTrue(moves.contains(new Move(3, 6, 2, 5)));
		Assert.assertTrue(moves.contains(new Move(3, 6, 4, 5)));
		Assert.assertTrue(moves.size() == 2);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(3, 4, Piece.RED_KING);
		List<Move> moves = board.getMoves(3, 4);
		Assert.assertTrue(moves.contains(new Move(3, 4, 4, 5)));
		Assert.assertTrue(moves.contains(new Move(3, 4, 4, 3)));
		Assert.assertTrue(moves.contains(new Move(3, 4, 2, 3)));
		Assert.assertTrue(moves.contains(new Move(3, 4, 2, 5)));
		Assert.assertTrue(moves.size() == 4);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(1, 4, Piece.WHITE_MAN);
		List<Move> moves = board.getMoves(1, 4);
		Assert.assertTrue(moves.contains(new Move(1, 4, 0, 5)));
		Assert.assertTrue(moves.contains(new Move(1, 4, 2, 5)));
		Assert.assertTrue(moves.size() == 2);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(3, 4, Piece.WHITE_KING);
		List<Move> moves = board.getMoves(3, 4);
		Assert.assertTrue(moves.contains(new Move(3, 4, 4, 5)));
		Assert.assertTrue(moves.contains(new Move(3, 4, 4, 3)));
		Assert.assertTrue(moves.contains(new Move(3, 4, 2, 5)));
		Assert.assertTrue(moves.contains(new Move(3, 4, 2, 3)));
		Assert.assertTrue(moves.size() == 4);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(3, 4, Piece.RED_KING);
		board.setPiece(4, 5, Piece.RED_MAN);
		board.setPiece(4, 3, Piece.RED_MAN);
		board.setPiece(2, 3, Piece.RED_MAN);
		board.setPiece(2, 5, Piece.RED_MAN);
		List<Move> moves = board.getMoves(3, 4);
		Assert.assertTrue(moves.size() == 0);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(0, 7, Piece.RED_KING);
		List<Move> moves = board.getMoves(0, 7);
		Assert.assertTrue(moves.contains(new Move(0, 7, 1, 6)));
		Assert.assertTrue(moves.size() == 1);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(7, 0, Piece.RED_KING);
		List<Move> moves = board.getMoves(7, 0);
		Assert.assertTrue(moves.contains(new Move(7, 0, 6, 1)));
		Assert.assertTrue(moves.size() == 1);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on an empty square
	 */
	public void testGetJumpsForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, null);
		List<Jump> jumps = board.getJumps(3, 4);
		Assert.assertNotNull(jumps);
		Assert.assertTrue(jumps.size() == 0);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(3, 4, Piece.RED_KING);
		List<Jump> jumps = board.getJumps(3, 4);
		Assert.assertTrue(jumps.size() == 0);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(3, 4, Piece.RED_KING);
		board.setPiece(2, 3, Piece.WHITE_MAN);
		board.setPiece(4, 5, Piece.WHITE_MAN);
		board.setPiece(2, 5, Piece.WHITE_MAN);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		List<Jump> jumps = board.getJumps(3, 4);
		Assert.assertTrue(jumps.contains(new Jump(3, 4, 2, 3, 1, 2)));
		Assert.assertTrue(jumps.contains(new Jump(3, 4, 4, 5, 5, 6)));
		Assert.assertTrue(jumps.contains(new Jump(3, 4, 2, 5, 1, 6)));
		Assert.assertTrue(jumps.contains(new Jump(3, 4, 4, 3, 5, 2)));
		Assert.assertTrue(jumps.size() == 4);
	}

	@Test
	/**
	 * Test that getJumps() returns the returns the correct Jump objects when a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(3, 4, Piece.RED_MAN);
		board.setPiece(2, 3, Piece.WHITE_MAN);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		List<Jump> jumps = board.getJumps(3, 4);
		Assert.assertTrue(jumps.contains(new Jump(3, 4, 2, 3, 1, 2)));
		Assert.assertTrue(jumps.contains(new Jump(3, 4, 4, 3, 5, 2)));
		Assert.assertTrue(jumps.size() == 2);
	}

}
