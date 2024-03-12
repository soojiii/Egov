package kr.or.ddit.calendar.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import kr.or.ddit.calendar.vo.CalendarVO;

public class CalendarDAOImpl implements CalendarDAO{
	private Properties props;
	public CalendarDAOImpl() {
		super();
		props = new Properties();
		try(
			InputStream is = this.getClass().getResourceAsStream("/kr/or/ddit/Nation.properties")
		){
			props.load(is);
		}catch(IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	private CalendarVO rawToObject(String locale, String rawData) {
		String[] tokens = rawData.split("\\|");
		CalendarVO world = new CalendarVO(locale, tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6], tokens[7], tokens[8]);
		return world;
	}
	
		
	@Override
	public List<CalendarVO> selectNationList() {
		List<CalendarVO> world = new ArrayList<CalendarVO>();
		Enumeration<Object> keys = props.keys();
		while (keys.hasMoreElements()) {
			Object key = (Object) keys.nextElement();
			Object value = props.get(key);
			CalendarVO dworld = rawToObject(key.toString(), value.toString());
			world.add(dworld);
		}
		return world;
	}

	
	@Override
	public CalendarVO selectNation(String locale) {
		String property = props.getProperty(locale);
		if(property!=null) {
			return rawToObject(locale, property);
		}else {
			return null;			
		}
	}
}
