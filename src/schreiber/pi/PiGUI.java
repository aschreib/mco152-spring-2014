package schreiber.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PiGUI extends JFrame {

	private JButton button;
	private JTextArea area;

	public PiGUI() {
		button = new JButton("Start");
		area = new JTextArea();

		setTitle("Pi GUI");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(button, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread t = new PiCalcThread(area);
				t.start(); // to start thread as its own thread
			}

		});

	}

	public static void main(String[] args) {
		PiGUI gui = new PiGUI();
		gui.setVisible(true);
	}
}
