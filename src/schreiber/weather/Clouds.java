package schreiber.weather;

public class Clouds {
	@Override
	public String toString() {
		return "Clouds [all=" + all + "]";
	}

	private final double all;

	public Clouds(int all) {
		super();
		this.all = all;
	}

	public double getAll() {
		return all;
	}
}
