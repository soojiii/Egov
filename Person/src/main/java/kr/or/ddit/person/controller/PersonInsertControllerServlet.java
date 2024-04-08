package kr.or.ddit.person.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.person.service.PersonService;
import kr.or.ddit.person.service.PersonServiceImpl;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.vo.PersonVO;

@WebServlet("/person/personInsert.do")
public class PersonInsertControllerServlet extends HttpServlet{

	private PersonService service = new PersonServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = "person/personForm";
		
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonVO person = new PersonVO();
		req.setAttribute("person", person);
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		PopulateUtils.populate(person, parameterMap);
		
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = ValidateUtils.validate(person, errors);
		String viewName = null;
		if(errors.isEmpty()) {
			ServiceResult result = service.createPerson(person);
			switch (result) {
			case PKDUPLICATED:
				req.setAttribute("message", "아이디 중복, 다른 아이디 사용해야 함");
				viewName = "prson/personForm";
				break;
			case FAIL:
				req.setAttribute("message", "서버 오류, 잠시 뒤 다시 가입하세요.");
				viewName = "person/personForm";
				break;

			default:
				viewName = "redirect:/person/personList.do";
				break;
			}
		}else {
			viewName = "person/personForm";
		}
			
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
	
		
}
