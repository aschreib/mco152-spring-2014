package schreiber.mtamap;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class RoutesTest {

	@Test
	public void testConstructor() throws IOException {
		new Routes();
	}

	@Test
	public void testGetRoutes() throws IOException {
		Routes routes = new Routes();
		Assert.assertNotNull(routes.getRoutes("SI"));
	}

	@Test
	public void testGetColor() throws IOException {
		Routes routes = new Routes();
		Assert.assertNotNull(routes.getColor("1"));
	}
}
