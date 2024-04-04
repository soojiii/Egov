package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberUpdate.do")
public class MemberUpdateControllerServlet extends HttpServlet {
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.isNew()) {
			resp.sendError(400);
			return;
		}
		String viewName = null;
		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		if(authMember==null) {
			viewName = "redirect:/login/loginForm.jsp";
		}else {
			MemberVO member = service.retrieveMember(authMember.getMemId());
			req.setAttribute("member", member);
			viewName = "/WEB-INF/views/member/memberForm.jsp";
		}
		
		if(viewName.startsWith("redirect:")) {
			String location = viewName.replace("redirect:", req.getContextPath());
			resp.sendRedirect(location);
		}else {
			req.getRequestDispatcher(viewName).forward(req, resp);			
		}
		
		
//		String memId = req.getParameter("who");
//		if(StringUtils.isBlank(memId)) {
//			resp.sendError(400);
//			return;
//		}
//		MemberVO member = service.retrieveMember(memId);
//		req.setAttribute("member", member);
//		String viewName = "/WEB-INF/views/member/memberForm.jsp";
//		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
		Map<String, String[]> parameterMap = req.getParameterMap();
//		try {
//			BeanUtils.populate(member, parameterMap);
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			throw new RuntimeException(e);
//		}
		
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = ValidateUtils.validate(member, errors);
		String viewName = null;
		if(errors.isEmpty()) {
			ServiceResult result = service.modifyMember(member);
			switch (result) {
			case INVALIDPASSWORD:
				req.setAttribute("message", "비밀번호 오류");
				viewName = "member/memberForm";
				break;
			case FAIL:
				req.setAttribute("message", "서버 오류, 잠시 뒤 다시 가입하세요.");
				viewName = "member/memberForm";
				break;

			default:
//				req.getSession().setAttribute("lastCreated", member);
				viewName = "redirect:/mypage";
				break;
			}
		}else {
			viewName = "member/memberForm";
		}
		
		new ViewResolverComposite().resolveView(viewName, req, resp);
//		if(viewName.startsWith("redirect:")) {
//			String location = viewName.replace("redirect:", req.getContextPath());
//			resp.sendRedirect(location);
//		}else {
//			req.getRequestDispatcher(viewName).forward(req, resp);			
//		}
	}
			
}







