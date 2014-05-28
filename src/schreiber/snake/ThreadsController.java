package schreiber.snake;

import java.util.ArrayList;

//Controls all the game logic .. most important class in this project.
public class ThreadsController extends Thread {
	private ArrayList<ArrayList<DataOfSquare>> Squares = new ArrayList<ArrayList<DataOfSquare>>();
	private Tuple headSnakePos;
	private int sizeSnake = 3;
	private long speed = 85;
	private int foodCount = 0;
	public static int directionSnake;

	ArrayList<Tuple> positions = new ArrayList<Tuple>();
	Tuple foodPosition;

	// Constructor of ControlleurThread
	ThreadsController(Tuple positionDepart) {
		// Get all the threads
		Squares = Window.Grid;

		headSnakePos = new Tuple(positionDepart.getX(), positionDepart.getY());
		directionSnake = 1;

		// !!! Pointer !!!!
		Tuple headPos = new Tuple(headSnakePos.getX(), headSnakePos.getY());
		positions.add(headPos);

		foodPosition = new Tuple(Window.height - 1, Window.width - 1);
		spawnFood(foodPosition);

	}

	// Important part :
	public void run() {
		while (true) {
			moveInterne(directionSnake);
			checkCollision();
			moveExterne();
			deleteTail();
			pauser();
		}
	}

	// delay between each move of the snake
	private void pauser() {
		try {
			sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Checking if the snake bites itself or is eating
	private void checkCollision() {
		Tuple posCritique = positions.get(positions.size() - 1);
		for (int i = 0; i <= positions.size() - 2; i++) {
			boolean biteItself = posCritique.getX() == positions.get(i).getX()
					&& posCritique.getY() == positions.get(i).getY();
			if (biteItself) {
				stopTheGame();
			}
		}

		boolean eatingFood = posCritique.getX() == foodPosition.getY()
				&& posCritique.getY() == foodPosition.getX();
		if (eatingFood) {
			System.out.println("Yesss!");
			foodCount++;
			sizeSnake = sizeSnake + 1;
			foodPosition = getValAleaNotInSnake();

			spawnFood(foodPosition);
		}
	}

	// Stops The Game
	private void stopTheGame() {
		System.out.println("YIKESSS! \nScore: " + foodCount);
		while (true) {
			pauser();
		}
	}

	// Put food in a position and displays it
	private void spawnFood(Tuple foodPositionIn) {
		Squares.get(foodPositionIn.getX()).get(foodPositionIn.getY())
				.lightMeUp(foodCount % 7);
	}

	// return a position not occupied by the snake
	private Tuple getValAleaNotInSnake() {
		Tuple p;
		int ranX = 0 + (int) (Math.random() * 19);
		int ranY = 0 + (int) (Math.random() * 19);
		p = new Tuple(ranX, ranY);
		for (int i = 0; i <= positions.size() - 1; i++) {
			if (p.getY() == positions.get(i).getX()
					&& p.getX() == positions.get(i).getY()) {
				ranX = 0 + (int) (Math.random() * 19);
				ranY = 0 + (int) (Math.random() * 19);
				p = new Tuple(ranX, ranY);
				i = 0;
			}
		}
		return p;
	}

	// Moves the head of the snake and refreshes the positions in the arraylist
	// 1:right 2:left 3:top 4:bottom 0:nothing
	private void moveInterne(int dir) {
		switch (dir) {
		case 4:
			headSnakePos.ChangeData(headSnakePos.getX(),
					(headSnakePos.getY() + 1) % 20);
			positions.add(new Tuple(headSnakePos.getX(), headSnakePos.getY()));
			break;
		case 3:
			if (headSnakePos.getY() - 1 < 0) {
				headSnakePos.ChangeData(headSnakePos.getX(), 19);
			} else {
				headSnakePos.ChangeData(headSnakePos.getX(),
						Math.abs(headSnakePos.getY() - 1) % 20);
			}
			positions.add(new Tuple(headSnakePos.getX(), headSnakePos.getY()));
			break;
		case 2:
			if (headSnakePos.getX() - 1 < 0) {
				headSnakePos.ChangeData(19, headSnakePos.getY());
			} else {
				headSnakePos.ChangeData(Math.abs(headSnakePos.getX() - 1) % 20,
						headSnakePos.getY());
			}
			positions.add(new Tuple(headSnakePos.getX(), headSnakePos.getY()));

			break;
		case 1:
			headSnakePos.ChangeData(Math.abs(headSnakePos.getX() + 1) % 20,
					headSnakePos.getY());
			positions.add(new Tuple(headSnakePos.getX(), headSnakePos.getY()));
			break;
		}
	}

	// Refresh the squares that needs to be
	private void moveExterne() {
		for (Tuple t : positions) {
			int y = t.getX();
			int x = t.getY();
			Squares.get(x).get(y).lightMeUp(7);

		}
	}

	// Refreshes the tail of the snake, by removing the superfluous data in
	// positions arraylist
	// and refreshing the display of the things that is removed
	private void deleteTail() {
		int cmpt = sizeSnake;
		for (int i = positions.size() - 1; i >= 0; i--) {
			if (cmpt == 0) {
				Tuple t = positions.get(i);
				Squares.get(t.getY()).get(t.getX()).lightMeUp(8);
			} else {
				cmpt--;
			}
		}
		cmpt = sizeSnake;
		for (int i = positions.size() - 1; i >= 0; i--) {
			if (cmpt == 0) {
				positions.remove(i);
			} else {
				cmpt--;
			}
		}
	}
}
