package kr.or.ddit.servlet04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * case1 : model1 + servlet spec  //책임이 쪼개지지 않았음, 가장피해야 하는 case, model1
 * case2 : template 구조 활용	//구조에 문제는없음, 단점은 코드가 복잡하다는 것, model2에 가까움
 * case3 : jsp 스펙 활용 //jsp한개만 만들었음, webapp/04/imageForm.jsp. model1
 * case4 : servlet + jsp --> model2  WEB-INF/views/04/imgeForm.jsp , model2
 * case5 : 비동기 처리 
 *
 */

@WebServlet("/case4/imageForm.do")
public class ImageFormServlet_case4 extends HttpServlet{
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		File folder = new File("F:/00.medias/images");
		String[] fileList = folder.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				String mime = application.getMimeType(name);
				return mime!=null && mime.startsWith("image/");
			}
		});
		StringBuffer options = new StringBuffer("");
		String optPtrn = "\n<option>%s</option>";
		for(String name : fileList) {
			options.append(String.format(optPtrn,name));
		}
		req.setAttribute("options", options);
		req.setAttribute("cPath", req.getContextPath());
		String viewName = "/WEB-INF/views/04/imageForm.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	
}
