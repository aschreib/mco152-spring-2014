package schreiber.forecast;

import java.net.MalformedURLException;

import org.junit.Test;

public class DownloadForecastThreadTest {

	@Test
	public void test() throws MalformedURLException {
		Thread t = new DownloadForecastThread(null);
	}

}
