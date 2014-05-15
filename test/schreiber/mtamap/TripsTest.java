package schreiber.mtamap;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class TripsTest {

	@Test
	public void testConstructor() throws IOException {
		new Trips();
	}

	@Test
	public void testGetTrip() throws IOException {
		final Trips trips = new Trips();
		Assert.assertNotNull("shapeId = 1..S03R not found",
				trips.getTrips("1..S03R"));
	}

}
