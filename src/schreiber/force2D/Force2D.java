package schreiber.force2D;

import java.text.DecimalFormat;

public class Force2D {

	private double x;
	private double y;

	public Force2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
		double magnitude = Math.sqrt((x * x) + (y * y));
		return magnitude;
	}

	public double getAngle() {
		double radians = Math.atan2(y, x);
		double angle = Math.toDegrees(radians);
		DecimalFormat formatter = new DecimalFormat("###.00");

		return Double.parseDouble(formatter.format(angle));
	}

	public Force2D add(Force2D other) {
		double newX = this.getX() + other.getX();
		double newY = this.getY() + other.getY();
		return new Force2D(newX, newY);
	}

}
