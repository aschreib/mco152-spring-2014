package schreiber.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT: // -> Right
			// if it's not the opposite direction
			if (ThreadsController.directionSnake != 2)
				ThreadsController.directionSnake = 1;
			break;
		case KeyEvent.VK_UP: // -> Top
			if (ThreadsController.directionSnake != 4)
				ThreadsController.directionSnake = 3;
			break;

		case KeyEvent.VK_LEFT: // -> Left
			if (ThreadsController.directionSnake != 1)
				ThreadsController.directionSnake = 2;
			break;

		case KeyEvent.VK_DOWN: // -> Bottom
			if (ThreadsController.directionSnake != 3)
				ThreadsController.directionSnake = 4;
			break;

		default:
			break;
		}
	}

}
