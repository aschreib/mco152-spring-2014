package schreiber.flicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

/**
 * Retrieves the Flicker feed and calls frame.loadImages()
 */
public class DownloadFlickerFeedThread extends Thread {

	private static final String FEED_URL = "https://api.flickr.com/services/feeds/photos_public.gne?id=20952345@N03&format=json";

	private URL url;
	private FlickerFeedFrame flickerFeedFrame;

	public DownloadFlickerFeedThread(final FlickerFeedFrame frame)
			throws MalformedURLException {
		url = new URL(FEED_URL);
		flickerFeedFrame = frame;
	}

	@Override
	public void run() {

		try {
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			JsonReader jsonReader = new JsonReader(reader);
			jsonReader.setLenient(true);
			jsonReader.nextString();
			Gson gson = new Gson();
			FlickerFeed feed = gson.fromJson(jsonReader, FlickerFeed.class);

			flickerFeedFrame.loadImages(feed);

		} catch (IOException iox) {
			System.out.println("error: ioexception");
		}

	}

}
