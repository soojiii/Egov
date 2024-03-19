package kr.or.ddit.bts;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.exception.ResponseStatusException;


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
		Map<String, String> btsMap = (Map) application.getAttribute("btsMap");
		try {
			String btsName = Optional.ofNullable(req.getParameter("name"))
					.filter(tp->!tp.isEmpty())
					.orElseThrow(()->new ResponseStatusException(400, "필수파라미터 누락"));
			if(!btsMap.containsKey(btsName)) {
				throw new ResponseStatusException(400, String.format("%s BTS 멤버에 없음.", btsName));
			}
			String content = String.format("/WEB-INF/views/bts/%s.jsp", btsName);
			req.setAttribute("content", content);
			String path = "/WEB-INF/views/bts/btsBase.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		
		}catch(ResponseStatusException e) {
			resp.sendError(e.getStatus(), e.getMessage());
		}
	}
}




