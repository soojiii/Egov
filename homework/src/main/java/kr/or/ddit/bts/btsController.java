package kr.or.ddit.bts;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, value ="/bts")
public class btsController extends HttpServlet{
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Map<String, String> btsMap = new LinkedHashMap<>();
		btsMap.put("rm", "RM");
		btsMap.put("jin", "진");
		btsMap.put("suga", "슈가");
		btsMap.put("jhop", "제이홉");
		btsMap.put("jimin", "지민");
		btsMap.put("bui", "뷔");
		btsMap.put("jungkuk", "정국");
		
		application = getServletContext();
		application.setAttribute("btsMap", btsMap);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/bts/btsForm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}




