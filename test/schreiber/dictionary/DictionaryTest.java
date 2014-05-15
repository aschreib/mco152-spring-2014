package schreiber.dictionary;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import schreiber.homework.Circle2D;

public class DictionaryTest {

	@Test
	public void testExists() throws FileNotFoundException {
		Dictionary dictionary = new Dictionary();
		boolean code = dictionary.exists("ABANDONED");

		Assert.assertTrue(code);
	}

}
