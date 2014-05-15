package schreiber.ufo;

public class ZipCode {

	private String zip;
	private String latitude;
	private String longitude;
	private String city;
	private String state;

	public ZipCode(String zip, String latitude, String longitude, String city,
			String state) {
		this.zip = zip;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

}
