package kr.or.ddit.person.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.person.service.PersonService;
import kr.or.ddit.person.service.PersonServiceImpl;
import kr.or.ddit.vo.PersonVO;

@WebServlet("/person/personList.do")
public class PersonListControllerServlet extends HttpServlet{
	
	private PersonService service = new PersonServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PersonVO> personList = service.retrievePersonList();
		
		req.setAttribute("personList", personList);
		
		String viewName = "person/personList";
		
		new ViewResolverComposite().resolveView(viewName, req, resp);
		
	
	}

}
