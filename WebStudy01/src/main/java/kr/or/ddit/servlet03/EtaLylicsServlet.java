package kr.or.ddit.servlet03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 사용자로부터 /eta 요청을 받고,
 * 컨텐츠 폴더에 있는 eta_utf8.txt 파일에 있는 가사를 컨텐츠로 서비스.
 *
 */
@WebServlet("/eta")
public class EtaLylicsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File readFile = new File("F:/00.medias/ETA_UTF8.txt");
		
		String mime = getServletContext().getMimeType(readFile.getName());
		resp.setContentType(String.format("%s;charset=UTF-8", mime));
		
		
		try(
			FileInputStream fis = new FileInputStream(readFile);  
				
			BufferedInputStream bis = new BufferedInputStream(fis); 
			
			OutputStream os = resp.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);	
			){
			int readByte = -1;
			while((readByte=bis.read())!=-1) { //EOF(EOS) 문자 : -1, null
				bos.write(readByte);
			}
			bos.flush();
		}
	}
}

