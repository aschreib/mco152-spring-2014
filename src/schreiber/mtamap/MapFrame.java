package schreiber.mtamap;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MapFrame extends JFrame {

	public MapFrame() {
		setTitle("MTA Map");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		add(new Map(), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		MapFrame frame = new MapFrame();
		frame.setVisible(true);
	}

}