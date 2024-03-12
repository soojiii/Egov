package kr.or.ddit.calendar.dao.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.calendar.service.CalendarService;
import kr.or.ddit.calendar.service.CalendarServiceImpl;
import kr.or.ddit.calendar.vo.CalendarVO;

@WebServlet("/nationList.do")
public class NationList extends HttpServlet {
	private CalendarService service = new CalendarServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<CalendarVO> world = service.selectNationList();
	StringBuffer sb = new StringBuffer();
	String ptrn = "<option value='%s'>%s</option>";
	for(CalendarVO vo : world) {
		if("대한민국".equals(vo.getId())) {
		String week = String.format("%s,%s,%s,%s,%s,%s,%s",vo.getSun(),vo.getMon(),vo.getTue(),vo.getWed(),vo.getThur(),vo.getFri(),vo.getSat());
		sb.append(String.format(ptrn,week,vo.getId()));
		}
	}
	
	for(CalendarVO vo : world) {
		if(!"대한민국".equals(vo.getId())) {
		String week = String.format("%s,%s,%s,%s,%s,%s,%s",vo.getSun(),vo.getMon(),vo.getTue(),vo.getWed(),vo.getThur(),vo.getFri(),vo.getSat());
		sb.append(String.format(ptrn,week,vo.getId()));
		}
	}
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	out.print(sb);
	out.close();
	
	}


}
