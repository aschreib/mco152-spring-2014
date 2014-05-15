package schreiber.stocks;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AmexDataTest {

	@Test
	public void testConstuctor() throws Exception {
		new AmexData();
	}

	@Test
	public void testContains() throws ParseException, IOException {
		AmexData data = new AmexData();
		Assert.assertTrue(data.contains("BOI"));
		Assert.assertFalse(data.contains("ASC"));
	}

	@Test
	public void testGetSymbol() throws ParseException, IOException {
		AmexData data = new AmexData();
		ArrayList<DailyPrice> noSymbol = (ArrayList<DailyPrice>) data
				.getPrices("ASC");
		Assert.assertNotNull(noSymbol);
		Assert.assertEquals(noSymbol.size(), 0);

		ArrayList<DailyPrice> hasSymbol = (ArrayList<DailyPrice>) data
				.getPrices("DSI");
		Assert.assertNotNull(hasSymbol);
		Assert.assertFalse(hasSymbol.size() == 0);

	}

	@Test
	public void testGetWithinDate() throws ParseException, IOException {
		AmexData data = new AmexData();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		ArrayList<DailyPrice> noSymbol = (ArrayList<DailyPrice>) data
				.getPrices("ASC", formatter.parse("2010-01-01"),
						formatter.parse("2010-01-02"));
		Assert.assertNotNull(noSymbol);
		Assert.assertEquals(noSymbol.size(), 0);

		ArrayList<DailyPrice> hasDate = (ArrayList<DailyPrice>) data.getPrices(
				"DSI", formatter.parse("2010-01-02"),
				formatter.parse("2010-07-02"));
		Assert.assertNotNull(hasDate);
		Assert.assertFalse(hasDate.size() == 0);
	}

}
