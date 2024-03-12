package kr.or.ddit.calendar.dao;

import java.util.List;

import kr.or.ddit.calendar.vo.CalendarVO;

public interface CalendarDAO {
	public List<CalendarVO> selectNationList();
	
	public CalendarVO selectNation(String locale);

	
}
