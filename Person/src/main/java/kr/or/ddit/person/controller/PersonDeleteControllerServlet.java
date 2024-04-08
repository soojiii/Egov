package kr.or.ddit.person.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.person.service.PersonService;
import kr.or.ddit.person.service.PersonServiceImpl;

@WebServlet("/person/personDelete.do")
public class PersonDeleteControllerServlet extends HttpServlet {
	
	private PersonService service = new PersonServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("who");
		if(StringUtils.isBlank(id)) {
			resp.sendError(400);
			return;
		}
		
		ServiceResult result = service.removePerson(id);
		String viewName = null;
		switch (result) {
		case FAIL:
			req.setAttribute("message", "서버 오류");
			viewName = "redirect:/person/personList.do";
			break;
		default:
			viewName = "redirect:/person/personList.do";
			break;
		}
		
		new ViewResolverComposite().resolveView(viewName, req, resp);
		
	}
	
}
