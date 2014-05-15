package schreiber.weather;

public class Weather {

	@Override
	public String toString() {
		return "Weather [id=" + id + ", main=" + main + ", description="
				+ description + ", icon=" + icon + "]";
	}

	private final int id;
	private final String main;
	private final String description;
	private final String icon;

	public int getId() {
		return id;
	}

	public String getMain() {
		return main;
	}

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	public Weather(int id, String main, String description, String icon) {
		super();
		this.id = id;
		this.main = main;
		this.description = description;
		this.icon = icon;

	}
}
