package schreiber.intervew;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueNumbers {

	public static void main(String[] args) {

		System.out.println("Please enter 10 numbers: ");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int num = input.nextInt();
			int instances = 1;
			if (map.containsKey(num)) {
				instances = map.get(num);
				instances++;
			}
			map.put(num, instances);
		}
		System.out.println(map);
	}
}
