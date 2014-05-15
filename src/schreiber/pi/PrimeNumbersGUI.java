package schreiber.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PrimeNumbersGUI extends JFrame implements ActionListener, Runnable {

	private JButton button;
	private JTextArea area;

	public PrimeNumbersGUI() {
		button = new JButton("Start");
		area = new JTextArea();

		setTitle("Prime Numbers");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(button, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);

		button.addActionListener(this);

		this.setVisible(true);

	}

	public static void main(String[] args) {
		PrimeNumbersGUI gui = new PrimeNumbersGUI();
		gui.setVisible(true);
	}

	@Override
	public void run() {
		boolean isPrime = true;
		for (int i = 1; i < 10000000; i++) {
			for (int j = 2; j * 2 < i; j++) {
				if (j % i == 0) {
					isPrime = false;
				}
			}
			if (isPrime = true) {
				System.out.println(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();
	}

}
