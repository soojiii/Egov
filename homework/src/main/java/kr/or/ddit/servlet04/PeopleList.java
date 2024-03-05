package kr.or.ddit.servlet04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/peopleList.do")
public class PeopleList extends HttpServlet {
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain;charset=UTF-8");
		File pList = new File("F:/D_setting/B_Util/7.Egov/eGovFrameDev-4.0.0-64bit/workspace/homework/src/main/resources/kr/or/ddit/MemberData.properties");
		
		StringBuffer html = new StringBuffer("");
		try(
			FileReader fr = new FileReader(pList);
			BufferedReader br = new BufferedReader(fr);
			PrintWriter out = resp.getWriter()
			){
				String line = null;
				while((line = br.readLine())!=null) {
					if(line.startsWith("#")) continue;
					int find = line.indexOf("=");
					int sind = line.indexOf("|");
					String fId = line.substring(0, find);
					String fName = line.substring(find+1, sind);
					html.append(String.format("<li onclick='pclick(event)' id='%s'>%s</li>", fId,fName));
				}
				
				out.print(html);
		}	
	}
	
}



