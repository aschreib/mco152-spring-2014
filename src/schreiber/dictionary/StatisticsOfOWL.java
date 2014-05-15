package schreiber.dictionary;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatisticsOfOWL {

	public static void main(String[] args) throws FileNotFoundException {
		Dictionary dictionary = new Dictionary();
		Map<String, String> map = dictionary.getDictionary();
		int numWords = map.size();
		char[] letters = new char[26];
		int[] numOccurences = new int[26];
		double[] percentOccurence = new double[26];

		List<String> list = new ArrayList<String>(map.keySet());

		char letter = 'A';
		for (int i = 0; i < 26; i++) {
			letters[i] = letter;
			letter++;
		}

		for (int j = 0; j < 26; j++) {
			int num = 0;
			for (int line = 0; line < numWords; line++) {
				for (int character = 0; character < list.get(line).length(); character++) {
					if (list.get(line).charAt(character) == letters[j]) {
						num++;
					}
				}
			}
			numOccurences[j] = num;
		}

		for (int k = 0; k < 26; k++) {
			double percent = 0.0;
			for (int line = 0; line < numWords; line++) {
				for (int character = 0; character < list.get(line).length(); character++) {
					if (list.get(line).charAt(character) == letters[k]) {
						percent++;
						break;
					}
				}
			}
			percentOccurence[k] = percent / numWords * 100;
		}

		StringBuilder stats = new StringBuilder();
		DecimalFormat formatter = new DecimalFormat("###.00");
		for (int print = 0; print < 26; print++) {
			stats.append(letters[print]);
			stats.append("\t");
			stats.append(numOccurences[print]);
			stats.append("\t");
			stats.append(formatter.format(percentOccurence[print]));
			stats.append("%\n");
		}
		System.out.println(stats.toString());

	}

}
