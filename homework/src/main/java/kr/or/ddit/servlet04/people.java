package kr.or.ddit.servlet04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/people.do")
public class people extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		resp.setContentType("text/html;charset=UTF-8");
		File pList = new File("F:/D_setting/B_Util/7.Egov/eGovFrameDev-4.0.0-64bit/workspace/homework/src/main/resources/kr/or/ddit/MemberData.properties");
		
		StringBuffer html = new StringBuffer("");
		try(
			FileReader fr = new FileReader(pList);
			BufferedReader br = new BufferedReader(fr);
			PrintWriter out = resp.getWriter()
			){
				String line = null;
				String target = null;
				while((line = br.readLine())!=null) {
					if(line.startsWith("#")) continue;
					int find = line.indexOf("=");
					String fId = line.substring(0, find);
					if(fId.equals(id)) {
						target = line.substring(find+1);
						break;
					}
				}
				
				String[] inf = target.split("\\|");
				String name = inf[0];
				String gender = inf[1];
				String age = inf[2];
				String address = inf[3];
				
				html.append("<table border='1'>");
				html.append("<tr>");
				html.append("<td>NAME</td>");
				html.append(String.format("<td>%s</td>",name));
				html.append("</tr>");
				html.append("<tr>");
				html.append("<td>GEDER</td>");
				html.append(String.format("<td>%s</td>",gender));
				html.append("</tr>");
				html.append("<tr>");
				html.append("<td>AGE</td>");
				html.append(String.format("<td>%s</td>",age));
				html.append("</tr>");
				html.append("<tr>");
				html.append("<td>ADDRESS</td>");
				html.append(String.format("<td>%s</td>",address));
				html.append("</tr>");
				html.append("</table>");
				
				out.print(html);
		}	
		
		
	}
	
	
}
