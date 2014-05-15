package schreiber.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class WeatherMain extends Thread {

	private String contentsOfConditions;
	private URL url;
	private WeatherFrame wf;

	public WeatherMain(String place, WeatherFrame weatherFrame)
			throws MalformedURLException {
		url = new URL("http://api.openweathermap.org/data/2.5/weather?q="
				+ place);
		wf = weatherFrame;
		this.contentsOfConditions = "";
	}

	@Override
	public void run() {

		try {
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			Gson gson = new Gson();
			Conditions c = gson.fromJson(reader, Conditions.class);
			contentsOfConditions = c.toString();
			this.wf.getTextArea().setText((contentsOfConditions));
		} catch (IOException io) {
			System.out.println("IOEXCeption. Sorry");
		}

	}

	public String getDesc() {
		return this.contentsOfConditions.toString();
	}

}
