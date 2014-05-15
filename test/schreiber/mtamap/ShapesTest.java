package schreiber.mtamap;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ShapesTest {

	@Test
	public void testConstructor() throws IOException {
		new Shapes();
	}

	@Test
	public void testGetShapes() throws IOException {
		Shapes shapes = new Shapes();
		Assert.assertNotNull(shapes.getShapes("4..N06R"));
	}

}
