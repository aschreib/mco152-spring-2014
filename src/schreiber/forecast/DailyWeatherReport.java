package schreiber.forecast;


public class DailyWeatherReport {
	private Weather[] weather;

	private Main main;
	private Wind wind;
	private Rain rain;
	private Clouds clouds;
	private String dt_txt;
	private long dt;
	private Sys sys;

	public Main getMain() {
		return main;
	}

	public String getDateText() {// throws ParseException {
		// TODO Auto-generated method stub

		return dt_txt;
	}
	/*
	 * date = Calendar.getInstance(); DateFormat df = new
	 * SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); String newDt_txt
	 * =dt_txt.replaceAll("-", "/"); date.setTime(df.parse(newDt_txt));
	 */

}
