package schreiber.maxSum;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxSum {

	public static void main(String[] args) throws FileNotFoundException {

		int dimensions = 0;
		int[][] values = new int[dimensions][dimensions];

		Scanner input = new Scanner(System.in);
		System.out.println("Enter your data: ");
		dimensions = input.nextInt();

		values = new int[dimensions][dimensions];
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				values[i][j] = input.nextInt();
			}

		}
		input.close();

		int maxsum = 0;
		for (int x = 0; x < dimensions; x++) { // starting row
			for (int y = 0; y < dimensions; y++) { // starting column
				for (int w = x; w < dimensions; w++) { // ending row
					for (int h = y; h < dimensions; h++) { // ending column
						int sum = 0;
						int thisX;
						int thisY;
						for (thisX = x; thisX <= w; thisX++) {
							for (thisY = y; thisY <= h; thisY++) {
								sum += values[thisX][thisY];
							}
							if (sum > maxsum) {
								maxsum = sum;
							}
						}

					}
				}
			}
		}
		System.out.println("Max sum: " + maxsum);
	}

}
