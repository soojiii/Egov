package kr.or.ddit.calendar.service;

import java.util.List;

import kr.or.ddit.calendar.vo.CalendarVO;

public interface CalendarService {
	public List<CalendarVO> selectNationList();
	public CalendarVO selectNation(String locale);
}
