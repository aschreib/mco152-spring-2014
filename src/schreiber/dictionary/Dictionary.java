package schreiber.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	private Map<String, String> map;

	public Dictionary() throws FileNotFoundException {

		map = new HashMap<String, String>();
		Scanner scanner = new Scanner(new File("OWL.txt"));
		while (scanner.hasNext()) {
			map.put(scanner.next(), scanner.nextLine());
			scanner.nextLine();
		}
		scanner.close();
	}

	public Map<String, String> getDictionary() {
		return map;
	}

	public Iterator<String> iterator() {
		return map.keySet().iterator();
	}

	public int size() {
		return map.size();
	}

	public boolean exists(String word) {
		return map.containsKey(word.toUpperCase());
	}

	public String getDefinition(String word) {
		return map.get(word.toUpperCase());
	}
}
