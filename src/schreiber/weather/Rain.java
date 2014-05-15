package schreiber.weather;

import com.google.gson.annotations.SerializedName;

public class Rain {

	@SerializedName("3h")
	private final int ThreeH;

	public Rain(int threeH) {
		super();
		ThreeH = threeH;
	}

	public int getThreeH() {
		return ThreeH;
	}

	@Override
	public String toString() {
		return "Rain [3h=" + ThreeH + "]";
	}
}
