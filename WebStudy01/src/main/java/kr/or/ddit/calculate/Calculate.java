package kr.or.ddit.calculate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.calculateEnum;


@WebServlet("/calculate.do")
public class Calculate extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String operator = "";
		
		String paramleftOp = request.getParameter("leftOp");
		String paramoperator = request.getParameter("operator");
		String paramrightOp = request.getParameter("rightOp");
		
		int lOp = Integer.parseInt(paramrightOp);
		int rOp = Integer.parseInt(paramrightOp);
		
		operator = calculateEnum.findoperatorName(paramoperator);
		
		String message = String.format("%s",1);
		try(
		PrintWriter out = response.getWriter();
		){
			out.print(message);
		}
	}
		
		

}
