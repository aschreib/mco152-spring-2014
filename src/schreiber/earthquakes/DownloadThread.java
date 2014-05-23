package schreiber.earthquakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class DownloadThread extends Thread {

	private static final String FEED_URL = "http://earthquake-report.com/feeds/recent-eq?json";

	private URL url;
	private EarthquakeFrame earthquakeFrame;

	public DownloadThread(final EarthquakeFrame frame)
			throws MalformedURLException {
		url = new URL(FEED_URL);
		earthquakeFrame = frame;
	}

	@Override
	public void run() {
		try {
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			JsonReader jsonReader = new JsonReader(reader);
			Gson gson = new Gson();
			EarthquakeStats statistics = gson.fromJson(jsonReader,
					EarthquakeStats.class);

			earthquakeFrame.loadList(statistics);

			// sleep(3000);
			// Thread refreshThread = new DownloadThread(earthquakeFrame);
			// refreshThread.start();
			// run();

		} catch (IOException ex) {
			System.out.println("error: ioexception");
		}
	}
}