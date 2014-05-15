package schreiber.weather;

import java.util.Arrays;

public class Conditions {

	private final Long dt;
	private final Long id;
	private final String name;
	private final int cod;
	private final Weather[] weather;
	private final String base;
	private final Clouds clouds;
	private final Coord coord;
	private final Main main;
	private final Rain rain;
	private final Sys sys;
	private final Wind wind;

	public Weather[] getWeather() {
		return weather;
	}

	@Override
	public String toString() {
		return "Conditions [dt=" + dt + ", id=" + id + ", name=" + name
				+ ", cod=" + cod + ", weather=" + Arrays.toString(weather)
				+ ", base=" + base + ", clouds=" + clouds + ", coord=" + coord
				+ ", main=" + main + ", rain=" + rain + ", sys=" + sys
				+ ", wind=" + wind + "]";
	}

	public String getBase() {
		return base;
	}

	public Clouds getCloud() {
		return clouds;
	}

	public Coord getCoord() {
		return coord;
	}

	public Main getMain() {
		return main;
	}

	public Rain getRain() {
		return rain;
	}

	public Sys getSys() {
		return sys;
	}

	public Wind getWind() {
		return wind;
	}

	public Conditions(Long dt, Long id, String name, int cod,
			Weather[] weather, String base, Clouds cloud, Coord coord,
			Main main, Rain rain, Sys sys, Wind wind) {
		super();
		this.dt = dt;
		this.id = id;
		this.name = name;
		this.cod = cod;
		this.weather = weather;
		this.base = base;
		this.clouds = cloud;
		this.coord = coord;
		this.main = main;
		this.rain = rain;
		this.sys = sys;
		this.wind = wind;
	}

	public Long getDt() {
		return dt;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCod() {
		return cod;
	}

}
