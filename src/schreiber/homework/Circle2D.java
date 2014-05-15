package schreiber.homework;

public class Circle2D {

	private double x;
	private double y;
	private double radius;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public Circle2D() {
		this.x = 0.0;
		this.y = 0.0;
		this.radius = 1.0;
	}

	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return Math.PI * radius * 2;
	}

	public double getDistance(double a, double b) {
		return Math.sqrt(((a - x) * (a - x)) + ((b - y) * (b - y)));
	}

	public boolean contains(double a, double b) {
		return getDistance(a, b) < radius;// if point is inside circle
	}

	public boolean contains(Circle2D circle) {
		return (getDistance(circle.x, circle.y) + circle.radius) < radius;
		// if circle is inside circle

	}

	public boolean overlaps(Circle2D circle) {
		return getDistance(circle.x, circle.y) < (circle.radius + radius);
		// if circle overlaps with circle

	}

}
