package schreiber.triangle;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void testTriangle1() {
		Triangle tri = new Triangle(3);
		String code = tri.toString();
		String expected = "  *" + "\n * *" + "\n*****";
		Assert.assertEquals(expected, code);
	}

	@Test
	public void testTriangle2() {
		Triangle tri = new Triangle(6);
		String code = tri.toString();
		String expected = "     *" + "\n    * *" + "\n   *   *" + "\n  *     *"
				+ "\n *       *" + "\n***********";
		Assert.assertEquals(expected, code);
	}

	@Test
	public void testTriangle3() {
		Triangle tri = new Triangle(10);
		String code = tri.toString();
		String expected = "         *" + "\n        * *" + "\n       *   *"
				+ "\n      *     *" + "\n     *       *" + "\n    *         *"
				+ "\n   *           *" + "\n  *             *"
				+ "\n *               *" + "\n*******************";
		Assert.assertEquals(expected, code);
	}
}
