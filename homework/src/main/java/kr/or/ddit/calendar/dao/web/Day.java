package kr.or.ddit.calendar.dao.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/day.do")
public class Day extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String paramYear = request.getParameter("year");
		String paramMonth = request.getParameter("month");
		String paramTzone = request.getParameter("tzone");
		System.out.println(paramTzone);
		if(paramTzone.contains(" ")){
			paramTzone = paramTzone.replace(" ", "+");
		}
		
		int year = Integer.parseInt(paramYear);
        int month = Integer.parseInt(paramMonth);
        String timeZone = paramTzone;

        // 타임존 설정
        ZoneId zoneId = ZoneId.of(timeZone);

        // 오늘 날짜
        LocalDate today = LocalDate.now(zoneId);

        // 해당 월 정보
        LocalDate startOfMonth = LocalDate.of(year, month, 1);
        LocalDate endOfMonth = startOfMonth.plusMonths(1).minusDays(1);
        LocalDate previousMonthEnd = startOfMonth.minusDays(1);

        // 요일 출력        
        String prtn = "{\"today\": \"%s\",\"week\": \"%s\",\"lastDay\": %s,\"exLastDay\": %s}";
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(String.format(prtn,today,startOfMonth.getDayOfWeek(),endOfMonth.getDayOfMonth(),previousMonthEnd.getDayOfMonth()));
        out.close();
        
		
	}	
}
