package schreiber.flicker;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a JLabel
 */
public class DownloadImageThread extends Thread {

	private JLabel label;
	private String url;

	public DownloadImageThread(final JLabel label, final String url) {
		// will need 20 of these
		this.label = label;
		this.url = url;
	}

	@Override
	public void run() {
		ImageIcon imgThisImg = new ImageIcon(url);
		label.setIcon(imgThisImg);
	}

}
