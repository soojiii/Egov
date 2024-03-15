package kr.or.ddit.login;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jdom2.IllegalAddException;

import kr.or.ddit.exception.ResponseStatusException;

@WebServlet("/login/loginProcess.do")
public class LoginProcessControllerServlet extends HttpServlet {
	private boolean authenticate(String id, String password) {
		return id.equals(password);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
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
