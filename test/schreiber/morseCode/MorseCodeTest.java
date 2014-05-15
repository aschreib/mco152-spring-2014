package schreiber.morseCode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testAlphabetToMorseCode() {

		MorseCode morseCode = new MorseCode();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String code = morseCode.toMorseCode(alphabet);
		String expected = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";

		Assert.assertEquals(expected, code.toString());
	}

	@Test
	public void testMorseCodeToAlphabet() {
		MorseCode morseCode = new MorseCode();
		String morse = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
		String code = morseCode.toPlainText(morse);
		String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		Assert.assertEquals(expected, code.toString());
	}

}
