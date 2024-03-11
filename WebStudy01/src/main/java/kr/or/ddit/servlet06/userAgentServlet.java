package kr.or.ddit.servlet06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.BrowserInfo;

@WebServlet("/07/userAgent.do")
public class userAgentServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String agent = req.getHeader("User-Agent").toUpperCase();
		String browserName = "기타";
		
//		Map<String, String> browserInfo = new LinkedHashMap<>();  //순서가 있는 Map
//		browserInfo.put("EDG", "엣지");
//		browserInfo.put("WHALE", "웨일");
//		browserInfo.put("CHROME", "크롬");
//		browserInfo.put("SAFARI", "사파리");
//		browserInfo.put("OTHER", "기타");
//		for(Entry<String, String> entry : browserInfo.entrySet()) {
//			if(agent.contains(entry.getKey())){
//				browserName = entry.getValue();
//				break;
//			}
//		}
		
//		BrowserInfo[] infos = BrowserInfo.values();
//		for(BrowserInfo single : infos) {
//			if(agent.contains(single.name())) {
//				browserName = single.getBrowserName();
//				break;
//			}
//		}
//		BrowserInfo finded = BrowserInfo.findBrowser(agent);
//		browserName = finded.getBrowserName();
//------------------------------------------------------------------------		
		
//		if(agent.contains("EDG")) {
//			browserName ="엣지";
//		}else if(agent.contains("WHALE")) {
//			browserName ="웨일";
//		}else if(agent.contains("CHROME")) {
//			browserName ="크롬";
//		}else if(agent.contains("SAFARI")) {
//			browserName ="사파리";
//		}else {
//			browserName ="기타";
//		}
//------------------------------------------------------------------------		
		
		browserName = BrowserInfo.findBrowserName(agent);
//------------------------------------------------------------------------		
		
		String message = String.format("당신의 브라우저는 %s입니다.", browserName);
		try(
		PrintWriter out = resp.getWriter();
		){
			out.print(message);
		}
		}
}
