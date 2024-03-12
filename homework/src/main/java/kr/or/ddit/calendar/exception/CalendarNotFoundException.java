package kr.or.ddit.calendar.exception;

public class CalendarNotFoundException extends RuntimeException{
	public CalendarNotFoundException(String locale) {
	super(String.format("해당[%s] 국가가 존재하지 않음.",locale));
	}
}