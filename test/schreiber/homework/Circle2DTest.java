package schreiber.homework;

import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {

	@Test
	public void testGetArea() {
		Circle2D circle = new Circle2D(2.0, 2.0, 5.5);
		double code = circle.getArea();
		double expected = Math.PI * 30.25;

		Assert.assertEquals(expected, code, .01);
	}

	@Test
	public void testGetPerimeter() {
		Circle2D circle = new Circle2D(2.0, 2.0, 5.5);
		double code = circle.getPerimeter();
		double expected = Math.PI * 11.0;

		Assert.assertEquals(expected, code, .01);
	}

	@Test
	public void testContainsPoint() {
		Circle2D circle = new Circle2D(2.0, 2.0, 5.5);
		Assert.assertTrue(circle.contains(3.0, 3.0));
	}

	@Test
	public void testContainsCircle() {
		Circle2D circle = new Circle2D(2.0, 2.0, 5.5);
		Assert.assertFalse(circle.contains(new Circle2D(4.0, 5.0, 10.5)));
	}

	@Test
	public void testOverlaps() {
		Circle2D circle = new Circle2D(2.0, 2.0, 5.5);
		Assert.assertTrue(circle.overlaps(new Circle2D(3.0, 5.0, 2.3)));
	}

}
