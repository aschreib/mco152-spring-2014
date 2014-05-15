package schreiber.checkers;

import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {
		return x >= 0 && x <= 7 && y >= 0 && y <= 7;
	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {
		return board[y][x] == null;
	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				board[y][x] = null;
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				board[y][x] = null;
			}
		}
		this.setPiece(1, 0, Piece.WHITE_MAN);
		this.setPiece(3, 0, Piece.WHITE_MAN);
		this.setPiece(5, 0, Piece.WHITE_MAN);
		this.setPiece(7, 0, Piece.WHITE_MAN);
		this.setPiece(0, 1, Piece.WHITE_MAN);
		this.setPiece(2, 1, Piece.WHITE_MAN);
		this.setPiece(4, 1, Piece.WHITE_MAN);
		this.setPiece(6, 1, Piece.WHITE_MAN);
		this.setPiece(1, 2, Piece.WHITE_MAN);
		this.setPiece(3, 2, Piece.WHITE_MAN);
		this.setPiece(5, 2, Piece.WHITE_MAN);
		this.setPiece(7, 2, Piece.WHITE_MAN);

		this.setPiece(0, 5, Piece.RED_MAN);
		this.setPiece(2, 5, Piece.RED_MAN);
		this.setPiece(4, 5, Piece.RED_MAN);
		this.setPiece(6, 5, Piece.RED_MAN);
		this.setPiece(1, 6, Piece.RED_MAN);
		this.setPiece(3, 6, Piece.RED_MAN);
		this.setPiece(5, 6, Piece.RED_MAN);
		this.setPiece(7, 6, Piece.RED_MAN);
		this.setPiece(0, 7, Piece.RED_MAN);
		this.setPiece(2, 7, Piece.RED_MAN);
		this.setPiece(4, 7, Piece.RED_MAN);
		this.setPiece(6, 7, Piece.RED_MAN);

	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString() {
		StringBuilder boardInfo = new StringBuilder();
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				if (board[y][x] == null) {
					boardInfo.append("-");
				} else {
					boardInfo.append(this.getPiece(x, y).toString());
				}
			}
			boardInfo.append("\n");
		}
		return boardInfo.toString().trim();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {
		int x1 = move.getX1();
		int y1 = move.getY1();
		int x2 = move.getX2();
		int y2 = move.getY2();

		this.setPiece(x2, y2, this.getPiece(x1, y1));
		this.setPiece(x1, y1, null);

		if (x2 == 0 && Piece.RED_MAN.equals(this.getPiece(x2, y2))) {
			this.setPiece(x2, y2, Piece.RED_KING);
		}
		if (x2 == 7 && Piece.WHITE_MAN.equals(this.getPiece(x2, y2))) {
			this.setPiece(x2, y2, Piece.WHITE_KING);
		}
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {
		int x1 = jump.getX1();
		int y1 = jump.getY1();
		int x2 = jump.getX2();
		int y2 = jump.getY2();
		int captureX = jump.getCaptureX();
		int captureY = jump.getCaptureY();

		this.setPiece(x2, y2, this.getPiece(x1, y1));
		this.setPiece(x1, y1, null);
		this.setPiece(captureX, captureY, null);

		if (x2 == 0 && Piece.RED_MAN.equals(this.getPiece(x2, y2))) {
			this.setPiece(x2, y2, Piece.RED_KING);
		}
		if (x2 == 7 && Piece.WHITE_MAN.equals(this.getPiece(x2, y2))) {
			this.setPiece(x2, y2, Piece.WHITE_KING);
		}
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		List<Move> moves = new ArrayList<Move>();
		if (this.getPiece(x, y) == null) {
			return moves;
		} else if (this.getPiece(x, y) == Piece.WHITE_MAN) {
			if (this.isOnBoard(x + 1, y + 1)
					&& (this.isEmptySquare(x + 1, y + 1))) {
				moves.add(new Move(x, y, x + 1, y + 1));
			}
			if (this.isOnBoard(x - 1, y + 1)
					&& (this.isEmptySquare(x - 1, y + 1))) {
				moves.add(new Move(x, y, x - 1, y + 1));
			}
		} else if (this.getPiece(x, y) == Piece.RED_MAN) {
			if (this.isOnBoard(x - 1, y - 1)
					&& (this.isEmptySquare(x - 1, y - 1))) {
				moves.add(new Move(x, y, x - 1, y - 1));
			}
			if (this.isOnBoard(x + 1, y - 1)
					&& (this.isEmptySquare(x + 1, y - 1))) {
				moves.add(new Move(x, y, x + 1, y - 1));
			}
		} else if (this.getPiece(x, y) == Piece.WHITE_KING
				|| this.getPiece(x, y) == Piece.RED_KING) {
			if (this.isOnBoard(x + 1, y + 1)
					&& this.isEmptySquare(x + 1, y + 1)) {
				moves.add(new Move(x, y, x + 1, y + 1));
			}
			if (this.isOnBoard(x + 1, y - 1)
					&& this.isEmptySquare(x + 1, y - 1)) {
				moves.add(new Move(x, y, x + 1, y - 1));
			}
			if (this.isOnBoard(x - 1, y + 1)
					&& this.isEmptySquare(x - 1, y + 1)) {
				moves.add(new Move(x, y, x - 1, y + 1));
			}
			if (this.isOnBoard(x - 1, y - 1)
					&& this.isEmptySquare(x - 1, y - 1)) {
				moves.add(new Move(x, y, x - 1, y - 1));
			}
		}
		return moves;
	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {
		List<Jump> jumps = new ArrayList<Jump>();
		if (this.getPiece(x, y) == null) {
			return jumps;
		} else if (this.getPiece(x, y) == Piece.WHITE_MAN) {
			if (this.getPiece(x - 1, y + 1) == Piece.RED_MAN
					|| this.getPiece(x - 1, y + 1) == Piece.RED_KING) {
				if (this.isOnBoard(x - 2, y + 2)
						&& this.isEmptySquare(x - 2, y + 2)) {
					jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
				}
			}
			if (this.getPiece(x + 1, y + 1) == Piece.RED_MAN
					|| this.getPiece(x + 1, y + 1) == Piece.RED_KING) {
				if (this.isOnBoard(x + 2, y + 2)
						&& this.isEmptySquare(x + 2, y + 2)) {
					jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}
			}
		} else if (this.getPiece(x, y) == Piece.RED_MAN) {
			if (this.getPiece(x - 1, y - 1) == Piece.WHITE_MAN
					|| this.getPiece(x - 1, y - 1) == Piece.WHITE_KING) {
				if (this.isOnBoard(x - 2, y - 2)
						&& this.isEmptySquare(x - 2, y - 2)) {
					jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
				}
			}
			if (this.getPiece(x + 1, y - 1) == Piece.WHITE_MAN
					|| this.getPiece(x + 1, y - 1) == Piece.WHITE_KING) {
				if (this.isOnBoard(x + 2, y - 2)
						&& this.isEmptySquare(x + 2, y - 2)) {
					jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}
			}
		} else if (this.getPiece(x, y) == Piece.WHITE_KING) {
			if (this.getPiece(x - 1, y - 1) == Piece.RED_MAN
					|| this.getPiece(x - 1, y - 1) == Piece.RED_KING) {
				if (this.isOnBoard(x - 2, y - 2)
						&& this.isEmptySquare(x - 2, y - 2)) {
					jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
				}
			}
			if (this.getPiece(x - 1, y + 1) == Piece.RED_MAN
					|| this.getPiece(x - 1, y + 1) == Piece.RED_KING) {
				if (this.isOnBoard(x - 2, y + 2)
						&& this.isEmptySquare(x - 2, y + 2)) {
					jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
				}
			}
			if (this.getPiece(x + 1, y + 1) == Piece.RED_MAN
					|| this.getPiece(x + 1, y + 1) == Piece.RED_KING) {
				if (this.isOnBoard(x + 2, y + 2)
						&& this.isEmptySquare(x + 2, y + 2)) {
					jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}
			}
			if (this.getPiece(x + 1, y - 1) == Piece.RED_MAN
					|| this.getPiece(x + 1, y - 1) == Piece.RED_KING) {
				if (this.isOnBoard(x + 2, y - 2)
						&& this.isEmptySquare(x + 2, y - 2)) {
					jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}
			}
		} else if (this.getPiece(x, y) == Piece.RED_KING) {
			if (this.getPiece(x - 1, y - 1) == Piece.WHITE_MAN
					|| this.getPiece(x - 1, y - 1) == Piece.WHITE_KING) {
				if (this.isOnBoard(x - 2, y - 2)
						&& this.isEmptySquare(x - 2, y - 2)) {
					jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
				}
			}
			if (this.getPiece(x - 1, y + 1) == Piece.WHITE_MAN
					|| this.getPiece(x - 1, y + 1) == Piece.WHITE_KING) {
				if (this.isOnBoard(x - 2, y + 2)
						&& this.isEmptySquare(x - 2, y + 2)) {
					jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
				}
			}
			if (this.getPiece(x + 1, y + 1) == Piece.WHITE_MAN
					|| this.getPiece(x + 1, y + 1) == Piece.WHITE_KING) {
				if (this.isOnBoard(x + 2, y + 2)
						&& this.isEmptySquare(x + 2, y + 2)) {
					jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}
			}
			if (this.getPiece(x + 1, y - 1) == Piece.WHITE_MAN
					|| this.getPiece(x + 1, y - 1) == Piece.WHITE_KING) {
				if (this.isOnBoard(x + 2, y - 2)
						&& this.isEmptySquare(x + 2, y - 2)) {
					jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}
			}
		}
		return jumps;
	}

}