package schreiber.clock;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class DisplayBasicClock extends JFrame {

	public DisplayBasicClock() {
		BasicClock clock = new BasicClock();

		JTextField text = new JTextField(clock.getHour() + ":"
				+ clock.getMinute() + ":" + clock.getSecond());

		getContentPane().add(clock);
		getContentPane().add(text, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		DisplayBasicClock frame = new DisplayBasicClock();
		frame.setTitle("Basic Clock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
	}
}
