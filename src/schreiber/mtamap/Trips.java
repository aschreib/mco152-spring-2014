package schreiber.mtamap;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Trips {

	private List<Trip> trips;

	public Trips() throws IOException {
		// read in files
		trips = new ArrayList<Trip>();
		File file = new File("trips.txt");
		CSVReader reader = new CSVReader(new FileReader(file), ',', '"', 1);
		String[] values;
		while ((values = reader.readNext()) != null) {
			String tripId = values[2];
			String routeId = values[0];
			String shapeId = values[6];
			Trip newTrip = new Trip(tripId, routeId, shapeId);
			trips.add(newTrip);
		}
		reader.close();
	}

	public List<Trip> getTripList() {
		return trips;
	}

	public List<Trip> getTrips(String tripId) {
		// list of trip objects that match that item
		List<Trip> foundTrips = new ArrayList<Trip>();
		for (int i = 0; i < trips.size(); i++) {
			if (trips.get(i).getTripId().equals(tripId)) {
				foundTrips.add(trips.get(i));
			}
		}
		return foundTrips;
	}

}
