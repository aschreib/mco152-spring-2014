

public class TicTacToeBoard {
	// TicTacToeBoard.java
	// holds the current state of the board
	private Symbol[][] gameBoard;

	public Symbol[][] getGameBoard() {
		return gameBoard;
	}

	public TicTacToeBoard() {
		this.gameBoard = new Symbol[3][3];
	}

	// void reset()
	// resets the game
	public void reset() {
		gameBoard = new Symbol[3][3];
	}

	// boolean isFull()
	// returns true if the board is full and there are no moves left, otherwise
	// false
	public boolean isFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameBoard[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	// setSquare(Location, Symbol)
	// places a symbol on the board in the specified location
	public void setSquare(Location loc, Symbol symbol) {
		gameBoard[loc.getX()][loc.getY()] = symbol;
	}

	// Symbol getSquare(Location)
	// returns the symbol on the board at the specified location, or null if no
	// symbol exists
	public Symbol getSquare(Location loc) {
		return gameBoard[loc.getX()][loc.getY()];
	}

}
