package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.lprod.controller.OthersControllerAdvice;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodUpdate.do")
public class ProdUpdateControllerServlet extends HttpServlet{
	private ProdService service = new ProdServiceImpl();
	private OthersControllerAdvice advice  = new OthersControllerAdvice();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		advice.addLprodList(req);
		advice.addBuyerList(req);
		
		String prodId = req.getParameter("what");
		if(StringUtils.isBlank(prodId)) {
			resp.sendError(400);
			return;
		}
		ProdVO prod = service.retrieveProd(prodId);
		req.setAttribute("prod", prod);
		
		String viewName = "prod/prodEdit";
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		advice.addLprodList(req);
		advice.addBuyerList(req);
		
		req.setCharacterEncoding("UTF-8");
		ProdVO prod = new ProdVO();
		req.setAttribute("prod", prod);
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		PopulateUtils.populate(prod, parameterMap);
		
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = ValidateUtils.validate(prod, errors, UpdateGroup.class);
		String viewName = null;
		if(errors.isEmpty()) {
			ServiceResult result = service.modifyProd(prod);
			switch (result) {
			case FAIL:
				req.setAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요.");
				viewName = "prod/prodEdit";
				break;
			default:
				viewName = "redirect:/prod/prodDetail.do?what="+prod.getProdId();
				break;
			}
		}else {
			viewName = "prod/prodEdit";
		}
		new ViewResolverComposite().resolveView(viewName, req, resp);
		
	}
}
