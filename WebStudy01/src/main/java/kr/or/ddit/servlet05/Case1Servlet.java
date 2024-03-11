package kr.or.ddit.servlet05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/06/case1Req.do")
public class Case1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// name : p2, value : 23
		String ptrn = "name : %s, value : %s\n";
//		sugar syntax
		req.getParameterMap().forEach((k,v)->System.out.printf(ptrn, k, Arrays.toString(v)));
		
		String accept = req.getHeader("Accept");
		String contentType = null;
		String content = null;
		
		if(accept.contains("json")){
			contentType = "application/json;charset=UTF-8";
			content = "{\"result\":\"처리 성공\"}";
		}else{
			contentType = "text/html;charset=UTF-8";
			content = "<html><body><h4>처리성공</h4></body></html>";
		}
		resp.setContentType(contentType);
		try (
		PrintWriter out = resp.getWriter();
		){
			out.print(content);
		}
		}
}
		


