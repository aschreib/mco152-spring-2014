package schreiber.mtamap;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.List;

import javax.swing.JComponent;

public class Map extends JComponent {

	@Override
	public void paintComponent(Graphics pen) {

		try {
			Routes routes = new Routes();
			Shapes shapes = new Shapes();
			Trips trips = new Trips();

			for (int i = 0; i < trips.getTripList().size(); i++) {
				String routeId = trips.getTripList().get(i).getRouteId();
				Color color = routes.getColor(routeId);

				pen.setColor(color);

				String shapeId = trips.getTripList().get(i).getShapeId();

				List<Shape> points = shapes.getShapes(shapeId);
				for (int j = 0; j < points.size() - 1; j++) {

					double latitude1 = points.get(j).getLatitude();
					double longitude1 = points.get(j).getLongitude();
					int x = (int) ((-1 * latitude1) + 90) * (600 / 180);
					int y = (int) (longitude1 + 180) * (800 / 360);

					double latitude2 = points.get(j + 1).getLatitude();
					double longitude2 = points.get(j + 1).getLongitude();
					int a = (int) ((-1 * latitude2) + 90) * (600 / 180);
					int b = (int) (longitude2 + 180) * (800 / 360);

					pen.drawLine(x, y, a, b);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
