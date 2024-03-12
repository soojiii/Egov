package kr.or.ddit.calendar.service;

import java.util.List;

import kr.or.ddit.calendar.dao.CalendarDAO;
import kr.or.ddit.calendar.dao.CalendarDAOImpl;
import kr.or.ddit.calendar.exception.CalendarNotFoundException;
import kr.or.ddit.calendar.vo.CalendarVO;

public class CalendarServiceImpl implements CalendarService{
	private CalendarDAO dao = new CalendarDAOImpl();
	
	@Override
	public List<CalendarVO> selectNationList() {
		List<CalendarVO> world = dao.selectNationList();
		return world;
	}

	@Override
	public CalendarVO selectNation(String locale) {
		CalendarVO nation = dao.selectNation(locale);
		if(nation==null)
			throw new CalendarNotFoundException(locale);
		return null;
	}
	
}
