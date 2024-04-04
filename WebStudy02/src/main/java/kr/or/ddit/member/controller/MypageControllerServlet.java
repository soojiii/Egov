package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/mypage")
public class MypageControllerServlet extends HttpServlet{
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
			viewName = "member/mypage";
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
