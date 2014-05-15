package schreiber.pi;

import javax.swing.JTextArea;

public class PiCalcThread extends Thread {

	private JTextArea area;

	public PiCalcThread(JTextArea area) {
		this.area = area;
	}

	@Override
	public void run() {
		double pi = 0.0;
		for (int i = 1; i < 1000000000; i++) {
			pi += 4 * Math.pow(-1, i + 1) / (2 * i - 1);
			area.setText(String.valueOf(pi));
		}
	}

}
