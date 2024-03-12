package kr.or.ddit.calendar.vo;

public class CalendarVO {

	public CalendarVO() {
		super();
	}
	



	private String locale;
	private String id;
	private String time_zone;
	private String mon;
	private String tue;
	private String wed;
	private String thur;
	private String fri;
	private String sat;
	private String sun;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getTime_zone() {
		return time_zone;
	}
	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}
	public String getMon() {
		return mon;
	}
	public void setMon(String mon) {
		this.mon = mon;
	}
	public String getTue() {
		return tue;
	}
	public void setTue(String tue) {
		this.tue = tue;
	}
	public String getWed() {
		return wed;
	}
	public void setWed(String wed) {
		this.wed = wed;
	}
	public String getThur() {
		return thur;
	}
	public void setThur(String thur) {
		this.thur = thur;
	}
	public String getFri() {
		return fri;
	}
	public void setFri(String fri) {
		this.fri = fri;
	}
	public String getSat() {
		return sat;
	}
	public void setSat(String sat) {
		this.sat = sat;
	}
	public String getSun() {
		return sun;
	}
	public void setSun(String sun) {
		this.sun = sun;
	}
	public CalendarVO(String locale, String id, String time_zone, String mon, String tue, String wed, String thur,
			String fri, String sat, String sun) {
		super();
		this.locale = locale;
		this.id = id;
		this.time_zone = time_zone;
		this.mon = mon;
		this.tue = tue;
		this.wed = wed;
		this.thur = thur;
		this.fri = fri;
		this.sat = sat;
		this.sun = sun;
	}
	
	@Override
	public String toString() {
		return "CalendarVO [locale=" + locale + ", id=" + id + ", time_zone=" + time_zone + ", mon=" + mon + ", tue="
				+ tue + ", wed=" + wed + ", thur=" + thur + ", fri=" + fri + ", sat=" + sat + ", sun=" + sun + "]";
	}
	
	
}
