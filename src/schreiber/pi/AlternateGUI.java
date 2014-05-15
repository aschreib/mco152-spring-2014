package schreiber.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AlternateGUI extends JFrame implements ActionListener, Runnable {

	private JButton button;
	private JTextArea area;

	public AlternateGUI() {
		button = new JButton("Start");
		area = new JTextArea();

		setTitle("Alternate GUI");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(button, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);

		button.addActionListener(this);

		this.setVisible(true);

	}

	public static void main(String[] args) {
		AlternateGUI gui = new AlternateGUI();
		gui.setVisible(true);
	}

	@Override
	public void run() {
		double pi = 0.0;
		for (int i = 1; i < 1000000000; i++) {
			pi += 4 * Math.pow(-1, i + 1) / (2 * i - 1);
			area.setText(String.valueOf(pi));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();
	}

}
