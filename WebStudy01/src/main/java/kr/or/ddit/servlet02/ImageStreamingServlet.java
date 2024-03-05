package kr.or.ddit.servlet02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/image.do")
public class ImageStreamingServlet extends HttpServlet {
	private ServletContext application;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		if(name==null || name.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "이미지 파일명이 잆음.");
			return;
		}
		
		File imageFolder = new File("F:/00.medias/images");
		File imageFile = new File(imageFolder, name);
		if(!imageFile.exists()) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, String.format("%s 파일은 없음.", name));
			return;
		}
//		if(!imageFile.canRead()) {
//			resp.sendError(400);
//			return;
//		}
		
		String mime = application.getMimeType(imageFile.getName());
		if(mime==null || !mime.startsWith("image")) {
			resp.sendError(400, "정상적인 이미지 파일이 아님.");
			return;
		}
		
		resp.setContentType(mime);
		resp.setContentLengthLong(imageFile.length());
		
		try(
			FileInputStream is = new FileInputStream(imageFile);
			BufferedInputStream bis = new BufferedInputStream(is);
			
			OutputStream os = resp.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);	
				
			) {
			int readByte = -1;
			while((readByte=bis.read())!=-1) { //EOF 문자 : -1, null
				bos.write(readByte);
			}
		}
//			byte[] buffer = new byte[1024];
//			int length = -1;
//			while((length = is.read(buffer))!=-1) {  //EOF 문자 : -1, null  (파일의끝)
//				os.write(buffer, 0, length);
//			}
	}	
}
