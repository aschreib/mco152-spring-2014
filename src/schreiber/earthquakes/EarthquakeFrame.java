package schreiber.earthquakes;

import java.awt.Color;
import java.awt.Component;
import java.net.MalformedURLException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class EarthquakeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String magnitude;
	private String location;

	private DefaultListModel listModel = new DefaultListModel();
	private JList list = new JList(listModel);
	private Component c;

	public EarthquakeFrame() throws MalformedURLException {
		setTitle("EARTHQUAKES");
		setSize(300, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(list);

		Thread thread = new DownloadThread(this);
		thread.start();
	}

	public void loadList(EarthquakeStats statistics) {
		for (Stats s : statistics) {
			magnitude = s.getMagnitude();
			location = s.getLocation();
			listModel.addElement(magnitude + "  " + location);
			// c = getListCellRendererComponent(list);
			// c.setBackground(setColor(magnitude));
		}
	}

	private Color setColor(String magnitude) {
		double mag = Double.parseDouble(magnitude);
		Color color = Color.white;

		if (mag == 10) {
			color = Color.red;
		} else if (mag >= 9) {
			color = Color.orange;
		} else if (mag >= 8) {
			color = Color.pink;
		} else if (mag >= 7) {
			color = Color.orange;
		} else if (mag >= 6) {
			color = Color.yellow;
		} else if (mag >= 5) {
			color = Color.green;
		} else if (mag >= 4) {
			color = Color.gray;
		} else if (mag >= 3) {
			color = Color.cyan;
		} else if (mag >= 2) {
			color = Color.blue;
		} else if (mag >= 1) {
			color = Color.magenta;
		}

		return color;

	}
}
