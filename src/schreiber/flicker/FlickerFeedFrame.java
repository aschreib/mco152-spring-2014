package schreiber.flicker;

import java.awt.GridLayout;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlickerFeedFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Item[] items;
	private Media media;
	private String m;
	private JLabel[] labels = new JLabel[20];

	public FlickerFeedFrame() throws MalformedURLException {
		// add
		setTitle("Flicker");
		setSize(800, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 20));

		// add each jlabel
		for (int i = 0; i < 20; i++) {
			labels[i] = new JLabel();
			add(labels[i]);
		}
		Thread thread = new DownloadFlickerFeedThread(this);
		thread.start();
	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 * 
	 * @throws MalformedURLException
	 */
	public void loadImages(final FlickerFeed feed) {
		items = feed.getItems();
		for (int i = 0; i < 20; i++) {
			media = items[i].getMedia();
			m = media.getM();
			Thread thread = new DownloadImageThread(labels[i], m);
			thread.start();
		}

	}

	public static void main(final String args[]) throws MalformedURLException {
		new FlickerFeedFrame().setVisible(true);
	}

}
