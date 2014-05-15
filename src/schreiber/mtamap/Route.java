package schreiber.mtamap;

import java.awt.Color;

public class Route {

	private String routeId;
	private Color color;

	public Route(String routeId, Color color) {
		this.routeId = routeId;
		this.color = color;
	}

	public String getRouteId() {
		return routeId;
	}

	public Color getColor() {
		return color;
	}

}
