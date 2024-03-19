package kr.or.ddit.servlet07;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.exception.ResponseStatusException;
import kr.or.ddit.utils.CookieMapRequestWrapper;

@WebServlet(loadOnStartup = 1, value ="/09/mbti")
public class MbtiControllerServlet extends HttpServlet{
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Map<String, String> mbtiMap = new LinkedHashMap<>();
		mbtiMap.put("istj", "1. ISTJ 소금형");
        mbtiMap.put("isfj", "2. ISFJ 권력형");
        mbtiMap.put("infj", "3. INFJ 예언자형");
        mbtiMap.put("intj", "4. INTJ 과학자형");
        mbtiMap.put("istp", "5. ISTP 백과사전형");
        mbtiMap.put("isfp", "6. ISFP 성인군자형");
        mbtiMap.put("infp", "7. INFP 잔다르크형");
        mbtiMap.put("intp", "8. INTP 아이디어형");
        mbtiMap.put("estp", "9. ESTP 활동가형");
        mbtiMap.put("esfp", "10. ESFP 사교형");
        mbtiMap.put("enfp", "11. ENFP 스파크형");
        mbtiMap.put("entp", "12. ENTP 발명가형");
        mbtiMap.put("estj", "13. ESTJ 사업가형");
        mbtiMap.put("esfj", "14. ESFJ 친선도모형");
        mbtiMap.put("enfj", "15. ENFJ 언변능숙형");
        mbtiMap.put("entj", "16. ENTJ 지도자형");
        
        application = getServletContext();
        application.setAttribute("mbtiMap", mbtiMap);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String findName = new CookieMapRequestWrapper(req).getCookieValue("mbtiCookie");
		req.setAttribute("mbtiCookieValue", findName);
		String path = "/WEB-INF/views/mbti/mbtiForm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		type 파라미터 필수
//		검증 누락되면 400에러발생
//		통과되면 html로 이동 forward
		Map<String, String> mbtiMap = (Map) application.getAttribute("mbtiMap");
		try {
			String mbtiType = Optional.ofNullable(req.getParameter("type"))
			    						.filter(tp->!tp.isEmpty())
			    						.orElseThrow(()->new ResponseStatusException(400, "필수파라미터 누락"));
			if(!mbtiMap.containsKey(mbtiType)) {
				throw new ResponseStatusException(400, String.format("%s mbti 유형은 없음.", mbtiType));
			}
			
			Cookie mbtiCookie = new Cookie("mbtiCookie", URLEncoder.encode(mbtiType, "UTF-8"));
			mbtiCookie.setPath(req.getContextPath());
			mbtiCookie.setMaxAge(60*60*24*3);
			resp.addCookie(mbtiCookie);
			
			String content = String.format("/WEB-INF/views/mbti/%s.html", mbtiType);
			req.setAttribute("content", content);
			String path = "/WEB-INF/views/mbti/base.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
			
		}catch(ResponseStatusException e) {
			resp.sendError(e.getStatus(), e.getMessage());
		}
	}
}
