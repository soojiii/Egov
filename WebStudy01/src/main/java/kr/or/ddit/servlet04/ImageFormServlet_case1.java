package kr.or.ddit.servlet04;

import java.io.File;
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
 * case1 : model1 + servlet spec
 * case2 : template 구조 활용
 * case3 : jsp 스펙 활용
 * case4 : servlet + jsp --> model2
 * case5 : 비동기 처리 
 *
 */

@WebServlet("/case1/imageForm.do")
public class ImageFormServlet_case1 extends HttpServlet{
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		File folder = new File("F:\\00.medias\\images");
		String[] fileList = folder.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				String mime = application.getMimeType(name);
				return mime!=null && mime.startsWith("image/");
			}
		});
		StringBuffer options = new StringBuffer("");
		String optptrn = "\n<option>%s</option>";
		for(String name : fileList) {
			options.append(String.format(optptrn,name));
		}
		
		StringBuffer html = new StringBuffer("");
		html.append("<html>");
		html.append("\n    <body>                                                       ");
		html.append(String.format("\n<form action='%s/image.do' method='get'>", req.getContextPath()));
		html.append("\n            <select name='name'>                     ");
		html.append(options);
		html.append("\n            </select>                                            ");
		html.append("\n            <button type='submit'>이미지 랜더링</button>         ");
		html.append("\n        </form>                                                  ");
		html.append("\n<script src='../resources/js/app/04/imageForm.js'></script>");
		html.append("\n    </body>                                                      ");
		html.append("\n</html>													  ");
		
		try(
			PrintWriter out = resp.getWriter()
		){
			out.println(html);
		}
		
	}
	
}
