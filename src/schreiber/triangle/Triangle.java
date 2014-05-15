package schreiber.triangle;

class Triangle {

	private int height;

	public Triangle(int height) {
		this.height = height;
	}

	public String toString() {
		StringBuilder triangle = new StringBuilder();
		int counter = 1;
		int spaces = 1;
		int base = (height * 2) - 1;
		// print first line
		for (int i = 0; i < height - counter; i++) {
			triangle.append(" ");
		}
		triangle.append("*\n");
		counter++;
		// print out body
		while (counter != height) {
			for (int i = 0; i < height - counter; i++) {
				triangle.append(" ");
			}
			triangle.append("*");
			for (int i = 0; i < spaces; i++) {
				triangle.append(" ");
			}
			triangle.append("*\n");
			counter++;
			spaces = spaces + 2;
		}
		// print bottom line
		for (int i = 0; i < base; i++) {
			triangle.append("*");
		}

		return triangle.toString();
	}

}
