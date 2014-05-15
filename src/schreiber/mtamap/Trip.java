package schreiber.mtamap;

public class Trip {

	private String tripId;
	private String routeId;
	private String shapeId;

	public Trip(String tripId, String routeId, String shapeId) {
		this.tripId = tripId;
		this.routeId = routeId;
		this.shapeId = shapeId;
	}

	public String getTripId() {
		return tripId;
	}

	public String getRouteId() {
		return routeId;
	}

	public String getShapeId() {
		return shapeId;
	}

}
