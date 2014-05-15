package schreiber.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class ListSightings {

	public static void main(String[] args) throws IOException {

		Gson gson = new Gson();

		FileReader reader = new FileReader(("ufo_awesome.json"));
		Sightings list = gson.fromJson(reader, Sightings.class);
		Map<String, List<Sighting>> map = new HashMap<>();

		for (Sighting s : list) {
			String location = s.getLocation();
			List<Sighting> sightings = map.get(location);
			if (sightings == null) {
				sightings = new ArrayList<Sighting>();
			}
			sightings.add(s);
			map.put(location, sightings);
		}

	}
}