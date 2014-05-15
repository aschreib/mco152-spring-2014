package schreiber.mtamap;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes {

	private List<Shape> shapes;

	public Shapes() throws IOException {
		// read in files
		shapes = new ArrayList<Shape>();
		File file = new File("shapes.txt");
		CSVReader reader = new CSVReader(new FileReader(file), ',', '"', 1);
		String[] values;
		while ((values = reader.readNext()) != null) {
			String shapeId = values[0];
			String latitude = values[1];
			String longitude = values[2];
			Shape newShape = new Shape(shapeId, Double.parseDouble(latitude),
					Double.parseDouble(longitude));
			shapes.add(newShape);
		}
		reader.close();
	}

	// public List<Shape> getShapeList() {
	// return shapes;
	// }

	public List<Shape> getShapes(String shapeId) {
		// list of shape objects that match that item
		List<Shape> foundShapes = new ArrayList<Shape>();
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i).getShapeId().equals(shapeId)) {
				foundShapes.add(shapes.get(i));
			}
		}
		return foundShapes;
	}

}
