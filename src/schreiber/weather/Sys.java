package schreiber.weather;

public class Sys {

	@Override
	public String toString() {
		return "Sys [message=" + message + ", country=" + country
				+ ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
	}

	private final double message;
	private final String country;
	private final Long sunrise;
	private final long sunset;

	public Sys(double message, String country, Long sunrise, long sunset) {
		super();
		this.message = message;
		this.country = country;
		this.sunrise = sunrise;
		this.sunset = sunset;
	}

	public double getMessage() {
		return message;
	}

	public String getCountry() {
		return country;
	}

	public Long getSunrise() {
		return sunrise;
	}

	public long getSunset() {
		return sunset;
	}
}
