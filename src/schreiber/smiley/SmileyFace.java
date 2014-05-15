package schreiber.smiley;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileyFace extends JComponent {

	@Override
	public void paintComponent(Graphics pen) {
		pen.setColor(Color.YELLOW);
		pen.drawLine(0, 0, getWidth(), getHeight());
		pen.drawLine(0, getHeight(), getWidth(), 0);
		pen.fillOval(getWidth() / 2 - 150, getHeight() / 2 - 150, 300, 300);

		pen.setColor(Color.BLACK);
		pen.fillOval(getWidth() / 2 + 15, getHeight() / 2 - 15, 30, 30);
	}

}
