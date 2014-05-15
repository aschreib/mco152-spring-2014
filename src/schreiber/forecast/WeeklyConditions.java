package schreiber.forecast;

import com.google.gson.annotations.SerializedName;

public class WeeklyConditions {
	private City city;
	@SerializedName("cod")
	private String code;

	private int cnt;
	private DWRList list;

	public DWRList getDwr() {
		return list;
	}

	public String getCode() {
		return code;
	}

	public void setDwr(DWRList dwr) {
		this.list = dwr;
	}

}
