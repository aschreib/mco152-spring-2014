package schreiber.forecast;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class GraphingComponent extends JComponent {

	private ArrayList<Double> tempList;
	private ArrayList<String> dateList;
	private JComponent jcomp;

	public GraphingComponent(ArrayList<Double> tempList,
			ArrayList<String> dateList) {
		this.tempList = tempList;
		this.dateList = dateList;
	}

	@Override
	public void paintComponent(Graphics g) {
		for (int i = 0; i > 6; i++) {
			int a = tempList.get(i).intValue();
			int b = i;
			int c = tempList.get(i + 1).intValue();
			int d = i + 1;

			g.drawLine(a, b, c, d);
		}
	}
}
