package schreiber.force2D;

import org.junit.Assert;
import org.junit.Test;

public class Force2DTest {

	@Test
	public void testGetMagnitude() {
		Force2D f = new Force2D(3, 4);
		double code = f.getMagnitude();
		double expected = 5;

		Assert.assertEquals(expected, code, 0.1);
	}

	@Test
	public void testGetAngle() {
		Force2D f = new Force2D(3, 4);
		double code = f.getAngle();
		double expected = 53.13;

		Assert.assertEquals(expected, code, 0.1);
	}

	@Test
	public void testAdd() {
		Force2D f1 = new Force2D(6, 6);
		Force2D f2 = new Force2D(6, 7);
		Force2D f3 = f1.add(f2);

		double codeX = f3.getX();
		double expectedX = 12;
		Assert.assertEquals(expectedX, codeX, 0);

		double codeY = f3.getY();
		double expectedY = 13;
		Assert.assertEquals(expectedY, codeY, 0);

	}

}
