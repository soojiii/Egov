package kr.or.ddit.servlet02;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imageForm.do")
public class ImageFormServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		File imageFolder = new File("F:/00.medias/images");
		
		StringBuffer content = new StringBuffer();
		content.append("<html>");
		content.append("<body>");
		content.append(String.format("<form action='%s/image.do' method='get'>", req.getContextPath()));
		content.append("<select name='name'>");
		for(String name :imageFolder.list()) {
			String mime = getServletContext().getMimeType(name);
			if(mime!=null && mime.startsWith("image")) {
				content.append(String.format("<option>%s</option>", name));
			}
		}
        content.append("</select>");
        content.append("<button type='submit'>이미지 랜더링</button>");
        content.append("</form>");
		content.append("</body>");
		content.append("</html>");
		PrintWriter out = resp.getWriter();
		out.print(content);
		out.close();
	}
}
