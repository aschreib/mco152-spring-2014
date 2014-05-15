package schreiber.weather;

public class Wind {

	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", deg=" + deg + "]";
	}

	private final double speed;
	private final double deg;

	public Wind(double speed, int deg) {
		super();
		this.speed = speed;
		this.deg = deg;
	}

	public double getSpeed() {
		return speed;
	}

	public double getDeg() {
		return deg;
	}
}
