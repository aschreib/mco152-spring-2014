package schreiber.morseCode;

import java.util.HashMap;
import java.util.StringTokenizer;

public class MorseCode {

	private HashMap<Character, String> charToCode;
	private HashMap<String, Character> codeToChar;

	public MorseCode() {
		charToCode = new HashMap<Character, String>(); // key is text
		codeToChar = new HashMap<String, Character>(); // key is code
		add("A", ".- ");
		add("B", "-... ");
		add("C", "-.-. ");
		add("D", "-.. ");
		add("E", ". ");
		add("F", "..-. ");
		add("G", "--. ");
		add("H", ".... ");
		add("I", ".. ");
		add("J", ".--- ");
		add("K", "-.- ");
		add("L", ".-.. ");
		add("M", "-- ");
		add("N", "-. ");
		add("O", "--- ");
		add("P", ".--. ");
		add("Q", "--.- ");
		add("R", ".-. ");
		add("S", "... ");
		add("T", "- ");
		add("U", "..- ");
		add("V", "...- ");
		add("W", ".-- ");
		add("X", "-..- ");
		add("Y", "-.-- ");
		add("Z", "--.. ");
		add("0", "----- ");
		add("1", ".---- ");
		add("2", "..--- ");
		add("3", "...-- ");
		add("4", "....- ");
		add("5", "..... ");
		add("6", "-.... ");
		add("7", "--... ");
		add("8", "---.. ");
		add("9", "----. ");
		add(" ", "/ ");

	}

	public void add(String s1, String s2) {
		charToCode.put(s1.charAt(0), s2);
		codeToChar.put(s2, s1.charAt(0));

	}

	public String toMorseCode(String plainText) {
		StringBuilder morse = new StringBuilder();
		add(plainText, morse.toString());
		for (int i = 0; i < plainText.length(); i++) {
			String upper = plainText.toUpperCase();
			if (upper.charAt(i) == ' ') {
			} else {
				morse.append(charToCode.get(upper.charAt(i)).toString());
			}

		}
		return morse.toString().trim();

	}

	public String toPlainText(String morseCode) {
		StringBuilder plainText = new StringBuilder();
		StringTokenizer tokenizer = new StringTokenizer(morseCode, " ");
		add(morseCode, plainText.toString());
		while (tokenizer.hasMoreTokens()) {
			String code = tokenizer.nextToken();
			plainText.append(codeToChar.get(code + " "));
		}

		return plainText.toString();
	}
}
