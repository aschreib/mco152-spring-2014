package schreiber.snake;

import java.awt.Color;
import java.util.ArrayList;

public class DataOfSquare {

	// ArrayList that'll contain the colors
	private ArrayList<Color> C = new ArrayList<Color>();
	private int color; // 2: snake , 1: food, 0:empty
	private SquarePanel square;

	public SquarePanel getSquare() {
		return square;
	}

	public DataOfSquare(int col) {

		// Lets add the color to the arrayList
		C.add(Color.BLUE);// 0
		C.add(Color.YELLOW); // 1
		C.add(Color.RED); // 2
		C.add(Color.ORANGE); // 3
		C.add(Color.CYAN); // 4
		C.add(Color.GREEN); // 5
		C.add(Color.PINK); // 6
		C.add(Color.darkGray); // 7
		C.add(Color.white); // 8
		color = col;
		square = new SquarePanel(C.get(color));
	}

	public void lightMeUp(int c) {
		square.ChangeColor(C.get(c));
	}
}
