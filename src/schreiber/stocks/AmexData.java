package schreiber.stocks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {
	private List<DailyPrice> dailyPricesList;
	private Map<String, List<DailyPrice>> dailyPricesMap;

	public AmexData() throws ParseException, IOException {
		dailyPricesList = new ArrayList<DailyPrice>();
		dailyPricesMap = new HashMap<>();
		String[] files = { "./resources/amex/AMEX_daily_prices_A.csv",
				"./resources/amex/AMEX_daily_prices_B.csv",
				"./resources/amex/AMEX_daily_prices_C.csv",
				"./resources/amex/AMEX_daily_prices_D.csv" };
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < 4; i++) {
			File file = new File(files[i]);
			CSVReader reader = new CSVReader(new FileReader(file), ',', '"', 1);
			String[] values;
			while ((values = reader.readNext()) != null) {
				String exchange = values[0];
				String symbol = values[1];
				Date date = formatter.parse(values[2]);
				double openPrice = Double.parseDouble(values[3]);
				double highPrice = Double.parseDouble(values[4]);
				double lowPrice = Double.parseDouble(values[5]);
				double closePrice = Double.parseDouble(values[6]);
				int volume = Integer.parseInt(values[7]);
				double adjustedClosePrice = Double.parseDouble(values[8]);
				DailyPrice newDailyPrice = new DailyPrice(exchange, symbol,
						date, openPrice, highPrice, lowPrice, closePrice,
						volume, adjustedClosePrice);
				if (dailyPricesMap.containsKey(symbol)) {
					dailyPricesList = dailyPricesMap.get(symbol);
					dailyPricesList.add(newDailyPrice);
					dailyPricesMap.put(symbol, dailyPricesList);
				} else {
					dailyPricesList = new ArrayList<DailyPrice>();
					dailyPricesList.add(newDailyPrice);
					dailyPricesMap.put(symbol, dailyPricesList);
				}
			}
		}

	}

	public boolean contains(String symbol) {
		return dailyPricesMap.containsKey(symbol);
	}

	public List<DailyPrice> getPrices(String symbol) {
		List<DailyPrice> foundSymbol = new ArrayList<DailyPrice>();
		if (dailyPricesMap.containsKey(symbol)) {
			foundSymbol = dailyPricesMap.get(symbol);
		}
		Collections.sort(foundSymbol);
		return foundSymbol;
	}

	public List<DailyPrice> getPrices(String symbol, Date startDate,
			Date endDate) {
		List<DailyPrice> foundDate = new ArrayList<DailyPrice>();
		List<DailyPrice> foundSymbol = new ArrayList<DailyPrice>();
		if (dailyPricesMap.containsKey(symbol)) {
			foundSymbol = dailyPricesMap.get(symbol);
			for (int i = 0; i < foundSymbol.size(); i++) {
				DailyPrice theDP = foundSymbol.get(i);
				Date theDate = theDP.getDate();
				if (theDate.compareTo(startDate) >= 0
						&& theDate.compareTo(endDate) <= 0) {
					foundDate.add(theDP);
				}
			}
			Collections.sort(foundDate);
		}
		return foundDate;
	}

}
