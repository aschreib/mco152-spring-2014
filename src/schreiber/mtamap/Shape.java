package schreiber.mtamap;

public class Shape {

	private String shapeId;
	private double latitude;
	private double longitude;

	public Shape(String shapeId, double latitude, double longitude) {
		this.shapeId = shapeId;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getShapeId() {
		return shapeId;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

}
