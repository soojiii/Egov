package kr.or.ddit.login;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.exception.ResponseStatusException;

@WebServlet("/login/loginProcess.do")
public class LoginProcessControllerServlet extends HttpServlet {
	private boolean authenticate(String id, String password) {
		return id.equals(password);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.isNew()) {
			resp.sendError(400, "로그인을 하려면 로그인 폼이 먼저 최초의 요청으로 전송되었어야 함.");
			return;
		}
		
//		1. body 영역의 디코딩에 사용할 charset 결정  
		req.setCharacterEncoding("UTF-8");
		try {
//		2. 필요 파라미터 확보
//		3. 파라미터 검증
//			- 검증 통과
		String memId = Optional.of(req.getParameter("memId"))
						.filter(id->!id.isEmpty())
						.orElseThrow(()->new ResponseStatusException(400,"아이디 누락"));
		String memPass = Optional.of(req.getParameter("memPass"))
						.filter(id->!id.isEmpty())
						.orElseThrow(()->new ResponseStatusException(400,"비밀번호 누락"));
//			4. 인증 여부 판단
			if(authenticate(memId, memPass)) {
//				인증된 사용자임을 증명하는 상태정보 생성 및 유지
				session.setAttribute("authId", memId);
//				- 성공 : 웰컴 페이지로 이동 - redirect
				resp.sendRedirect(req.getContextPath()+"/");
			}else {
//				- 실패 : 로그인 페이지로 이동 - forward
				session.setAttribute("message", "로그인 실패");
//				req.getRequestDispatcher("/login/loginForm.jsp").forward(req, resp);
				resp.sendRedirect(req.getContextPath()+"/login/loginForm.jsp");
			}
		}catch(ResponseStatusException e) {
//			- 불통과 : 상태코드 400 전송
			resp.sendError(e.getStatus(), e.getMessage());
		}
			
		
		
		
			
	}
}
