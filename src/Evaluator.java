

import java.util.ArrayList;
import java.util.List;

public class Evaluator {
	// Evaluator.java
	// evaluates the TicTacToeBoard
	private TicTacToeBoard board;
	private Symbol winner;
	private List<Location> winningSquares;

	// Evaluator(TicTacToeBoard)
	// constructor that passes in a board
	public Evaluator(TicTacToeBoard board) {
		this.board = board;
	}

	// void evaluate()
	// scans the board for a winner and the winning squares
	public void evaluate() {
		Symbol[][] thisBoard = board.getGameBoard();
		Symbol theSymbol = null;
		// check for 3 in a row
		for (int i = 0; i < 3; i++) {
			if (thisBoard[i][0] != null) {
				theSymbol = thisBoard[i][0];
				int row = i;
				if (thisBoard[i][1] != null
						&& thisBoard[i][1].equals(theSymbol)) {
					if (thisBoard[i][2] != null
							&& thisBoard[i][2].equals(theSymbol)) {
						winningSquares = new ArrayList<Location>();
						winner = theSymbol;
						winningSquares.add(new Location(row, 0));
						winningSquares.add(new Location(row, 1));
						winningSquares.add(new Location(row, 2));
						break;
					}
				}
			}
		}
		// check for 3 in a column
		for (int j = 0; j < 3; j++) {
			if (thisBoard[0][j] != null) {
				theSymbol = thisBoard[0][j];
				int column = j;
				if (thisBoard[1][j] != null
						&& thisBoard[1][j].equals(theSymbol)) {
					if (thisBoard[2][j] != null
							&& thisBoard[2][j].equals(theSymbol)) {
						winner = theSymbol;
						winningSquares = new ArrayList<Location>();
						winningSquares.add(new Location(0, column));
						winningSquares.add(new Location(1, column));
						winningSquares.add(new Location(2, column));
						break;
					}
				}
			}
		}
		// check for downward diagonal
		if (thisBoard[0][0] != null) {
			theSymbol = thisBoard[0][0];
			if (thisBoard[1][1] != null && thisBoard[1][1].equals(theSymbol)) {
				if (thisBoard[2][2] != null
						&& thisBoard[2][2].equals(theSymbol)) {
					winner = theSymbol;
					winningSquares = new ArrayList<Location>();
					winningSquares.add(new Location(0, 0));
					winningSquares.add(new Location(1, 1));
					winningSquares.add(new Location(2, 2));
				}
			}
		}
		// check for a upward diagonal
		if (thisBoard[2][0] != null) {
			theSymbol = thisBoard[2][0];
			if (thisBoard[1][1] != null && thisBoard[1][1].equals(theSymbol)) {
				if (thisBoard[0][2] != null
						&& thisBoard[0][2].equals(theSymbol)) {
					winner = theSymbol;
					winningSquares = new ArrayList<Location>();
					winningSquares.add(new Location(2, 0));
					winningSquares.add(new Location(1, 1));
					winningSquares.add(new Location(0, 2));
				}
			}
		}

	}

	// Symbol getWinner()
	// returns the winner or null if no winner exists
	public Symbol getWinner() {
		return winner;
	}

	public void resetWinner() {
		winner = null;
	}

	// List<Location> getWinningSquares()
	// returns the winning squares or null if there are no winning squares
	public List<Location> getWinningSquares() {
		return winningSquares;
	}

	public void resetWinningSquares() {
		winningSquares = null;
	}

	// testNoWinnerOnBlankBoard

	// testNoWinnerOnFullBoard
}
