package kr.or.ddit.servlet10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.db.ConnectionFactory_JDBC_Ver1;
import kr.or.ddit.exception.PersistenceException;
import kr.or.ddit.servlet10.service.PropertyService;
import kr.or.ddit.servlet10.service.PropertyServiceImpl;
import kr.or.ddit.utils.NamingUtils;

@WebServlet("/15/jdbcDesc.do")
public class JdbcDescServlet extends HttpServlet {
	private PropertyService service = new PropertyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> paramMap = new HashMap<>();
		service.readProperties(paramMap);
		
		for(Entry<String, Object> entry : paramMap.entrySet()) {
			request.setAttribute(entry.getKey(), entry.getValue());
		}
		
		String accept = request.getHeader("accept");
		String viewName = null;
		if(accept.contains("json")) {
			viewName = "/jsonView.do";
		}else {
			viewName = "/WEB-INF/views/15/jdbcDesc.jsp";
		}
		request.getRequestDispatcher(viewName).forward(request, resp);
	}
}
