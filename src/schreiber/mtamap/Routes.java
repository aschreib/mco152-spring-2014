package schreiber.mtamap;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Routes {

	private List<Route> routes;

	public Routes() throws IOException {
		routes = new ArrayList<Route>();
		File file = new File("routes.txt");
		CSVReader reader = new CSVReader(new FileReader(file), ',', '"', 1);
		String[] values;
		while ((values = reader.readNext()) != null) {
			String routeId = values[0];
			if (!"".equals(values[7])) {
				String hexColor = values[7];
				Color color = Color.decode("#" + hexColor);
				Route newRoute = new Route(routeId, color);
				routes.add(newRoute);
			}
		}
		reader.close();
	}

	public List<Route> getRouteList() {
		return routes;
	}

	public List<Route> getRoutes(String routeId) {
		List<Route> foundRoutes = new ArrayList<Route>();
		for (int i = 0; i < routes.size(); i++) {
			if (routes.get(i).getRouteId().equals(routeId)) {
				foundRoutes.add(routes.get(i));
			}
		}
		return foundRoutes;
	}

	public Color getColor(String routeId) {
		Color theColor = null;
		for (int i = 0; i < routes.size(); i++) {
			if (routes.get(i).getRouteId().equals(routeId)) {
				theColor = routes.get(i).getColor();
				break;
			}
		}
		return theColor;
	}

}
