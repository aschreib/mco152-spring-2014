package schreiber.clock;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ClockPanel extends JPanel {
	private ClockThread clock = new ClockThread();

	public ClockPanel() {
		setLayout(new BorderLayout());
		add(clock, BorderLayout.CENTER);
	}
}
