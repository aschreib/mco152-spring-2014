package schreiber.ufo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class ZipCodes {

	private List<ZipCode> zipCodes;

	public List<ZipCode> getZipList() {
		return zipCodes;
	}

	public ZipCodes() throws IOException {
		zipCodes = new ArrayList<ZipCode>();
		File file = new File("ZIP_CODES.txt");
		CSVReader reader = new CSVReader(new FileReader(file));
		String[] values;
		while ((values = reader.readNext()) != null) {
			String zip = values[0];
			String latitude = values[1];
			String longitude = values[2];
			String city = values[3];
			String state = values[4];
			ZipCode newZip = new ZipCode(zip, latitude, longitude, city, state);
			zipCodes.add(newZip);
		}
		reader.close();
	}

}
