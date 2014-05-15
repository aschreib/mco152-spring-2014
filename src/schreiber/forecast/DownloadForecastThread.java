package schreiber.forecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.google.gson.Gson;

public class DownloadForecastThread extends Thread {

	private URL url;
	private ForecastFrame forecastFrame;
	private ArrayList<Double> tempList;
	private ArrayList<String> dateList;

	public DownloadForecastThread(final ForecastFrame frame)
			throws MalformedURLException {
		url = new URL(
				"http://api.openweathermap.org/data/2.5/forecast?q=London,uk");
		forecastFrame = frame;
	}

	@Override
	public void run() {

		try {
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			Gson gson = new Gson();

			WeeklyConditions cond = gson.fromJson(reader,
					WeeklyConditions.class);
			DWRList list = cond.getDwr();
			tempList = new ArrayList<Double>();
			dateList = new ArrayList<String>();
			for (DailyWeatherReport dwr : list) {
				Double temp = dwr.getMain().getTemp();
				tempList.add(temp);
				String date = dwr.getDateText();
				dateList.add(date);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Double> getTempList() {
		return tempList;
	}

	public ArrayList<String> getDateList() {
		return dateList;
	}

}
