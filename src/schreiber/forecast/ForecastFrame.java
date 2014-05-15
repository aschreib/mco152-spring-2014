package schreiber.forecast;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ForecastFrame extends JFrame {

	private ForecastPanel panel;
	private JTextArea area;
	private JButton button;
	private ArrayList<Double> tempList;
	private ArrayList<String> dateList;

	public ForecastFrame() {
		setTitle("Weekly Temperature");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton("Enter");
		area = new JTextArea();
		panel = new ForecastPanel();

		add(panel, BorderLayout.CENTER);
		add(area, BorderLayout.NORTH);
		add(button, BorderLayout.AFTER_LAST_LINE);

		button.addActionListener(null);
	}

	public void actionPerformed(ActionEvent e) throws MalformedURLException {
		String place = panel.getUserInput();
		Thread thread = new DownloadForecastThread(this);
		thread.start();
		tempList = ((DownloadForecastThread) thread).getTempList();
		dateList = ((DownloadForecastThread) thread).getDateList();
		GraphingComponent gc = new GraphingComponent(tempList, dateList);
		this.add(gc);
	}

	public JTextArea getTextArea() {
		// TODO Auto-generated method stub
		return this.area;
	}

	public static void main(String[] args) {
		new ForecastFrame().setVisible(true);
	}

}
