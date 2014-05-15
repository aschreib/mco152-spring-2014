package schreiber.flicker;

import javax.swing.Icon;
import javax.swing.JLabel;

import org.junit.Test;
import org.mockito.Mockito;

public class DownloadImageThreadTest {

	@Test
	public void testCallLoadImages() {
		final JLabel label = Mockito.mock(JLabel.class);

		final DownloadImageThread thread = new DownloadImageThread(label,
				"https://farm3.staticflickr.com/2902/14179574494_91cfe3247a_m.jpg");

		Mockito.verify(label, Mockito.never()).setIcon(Mockito.any(Icon.class));

		thread.run();
		Mockito.verify(label, Mockito.times(1))
				.setIcon(Mockito.any(Icon.class));
	}

}
