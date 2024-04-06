package kr.or.ddit.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * session scope 에 "authMember"라는 속성이 존재하면, 
 * 현재 request에 Wrapper 를 만들고, 해당 wrapper 통해 Userprincipal 을 관리하기 위한 필터
 *
 */
@Slf4j
public class GeneratePrincipalFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("{} 초기화되었음.", this.getClass().getSimpleName());
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Object authMember = req.getSession().getAttribute("authMember");
		if(authMember==null) {
			chain.doFilter(request, response);
		}else {
			UserPrincipalRequestWrapper wrapper = new UserPrincipalRequestWrapper(req);
			chain.doFilter(wrapper, response);
		}
	}

	@Override
	public void destroy() {
		log.info("{} 소멸되었음.", this.getClass().getSimpleName());
	}

}
