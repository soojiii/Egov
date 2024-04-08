package kr.or.ddit.person.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.person.service.PersonService;
import kr.or.ddit.person.service.PersonServiceImpl;
import kr.or.ddit.vo.PersonVO;

@WebServlet("/person/personDetail.do")
public class PersonDetailControllerServlet extends HttpServlet {
	
	private PersonService service = new PersonServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("who");
		if(StringUtils.isBlank(id)) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		}
		
		PersonVO person = service.retrievePerson(id);
		req.setAttribute("person", person);
		String viewName = "person/personDetail";
		
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
}
