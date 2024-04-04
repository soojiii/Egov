package kr.or.ddit.member.controller;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.MemberVO;

/**
 * 1. 요청 접수, 분석
 * 2. 검증
 * 3. 로직 사용(model 확보)
 * 4. scope 를 이용해 model 공유
 * 5. view 결정
 * 6. view 로 이동 (flow control)
 *
 */
@WebServlet("/member/memberInsert.do")
public class MemberInsertControllerServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName ="/WEB-INF/views/member/memberForm.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 * 1. 요청 접수, 분석 (body안의 특수문자를 잘 가져울수있어야함)
		req.setCharacterEncoding("UTF-8");
		MemberVO member = new MemberVO(); //command Object
		req.setAttribute("member", member);
		Map<String, String[]> parameterMap = req.getParameterMap();
//		try {
//			BeanUtils.populate(member, parameterMap);
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			throw new RuntimeException(e);
//		}
		PopulateUtils.populate(member, parameterMap);
		
		System.out.println(member);
		
//		for(Entry<String, String[]> entry : parameterMap.entrySet()) {
//			String paramName = entry.getKey();
//			String paramValue = entry.getValue()[0];
////			System.out.printf("%s : %s\n", paramName, paramValue);
//		}
		
//		 * 2. 검증
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = ValidateUtils.validate(member, errors, InsertGroup.class);
		String viewName = null;
		if(errors.isEmpty()) {
//		 * 3. 로직 사용(model 확보)
			ServiceResult result = service.createMember(member);
			switch (result) {
			case PKDUPLICATED:
				req.setAttribute("message", "아이디 중복, 다른 아이디 사용해야 함");
				viewName = "/WEB-INF/views/member/memberForm.jsp";
				break;
			case FAIL:
				req.setAttribute("message", "서버 오류, 잠시 뒤 다시 가입하세요.");
				viewName = "/WEB-INF/views/member/memberForm.jsp";
				break;

			default:
				viewName = "redirect:/";
				break;
			}
//		 * 4. scope 를 이용해 model 공유
		}else {
			viewName = "/WEB-INF/views/member/memberForm.jsp";
		}
//		 * 5. view 결정
//		 * 6. view 로 이동 (flow control)
		if(viewName.startsWith("redirect:")) {
			String location = viewName.replace("redirect:", req.getContextPath());
			resp.sendRedirect(location);
		}else {
			req.getRequestDispatcher(viewName).forward(req, resp);			
		}
	}
}
