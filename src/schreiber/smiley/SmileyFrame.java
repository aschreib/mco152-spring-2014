package schreiber.smiley;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SmileyFrame extends JFrame {

	public SmileyFrame() {
		setTitle("Smile!");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		add(new SmileyFace(), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SmileyFrame frame = new SmileyFrame();
		frame.setVisible(true);
	}

}
