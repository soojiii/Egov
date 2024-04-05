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


import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.lprod.controller.OthersControllerAdvice;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodInsert.do")
public class ProdInsertControllerServlet extends HttpServlet{
	private ProdService service = new ProdServiceImpl();
	private OthersControllerAdvice advice  = new OthersControllerAdvice();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		advice.addLprodList(req);
		advice.addBuyerList(req);
		
		String viewName ="prod/prodForm";
		
		new ViewResolverComposite().resolveView(viewName, req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		advice.addLprodList(req);
		advice.addBuyerList(req);
		
//		 * 1. 요청 접수, 분석
		req.setCharacterEncoding("UTF-8");
		ProdVO prod = new ProdVO(); //command Object
		req.setAttribute("prod", prod);
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		PopulateUtils.populate(prod, parameterMap);
		
		
//		AbstractConverter localDateConverter = new AbstractConverter() {
//			
//			@Override
//			protected Class<?> getDefaultType() {
//				return LocalDate.class;
//			}
//			
//			@Override
//			protected <T> T convertToType(Class<T> type, Object value) throws Throwable {
//				if(value==null || value.toString().isEmpty())
//					return null;
//				else {
//					String paramValue = value.toString();
//					return (T) LocalDate.parse(paramValue);
//				}
//			}
//		};
//		
//		ConvertUtils.register(localDateConverter, LocalDate.class);
//		
//		try {
//			BeanUtils.populate(prod, parameterMap);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
////			String insdate = req.getParameter("prodInsdate");
////			LocalDate prodInsDate = LocalDate.parse(insdate);
////			prod.setProdInsdate(prodInsDate);
//		}
		
//		 * 2. 검증
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = ValidateUtils.validate(prod, errors, InsertGroup.class);
		String viewName = null;
		if(errors.isEmpty()) {
//		 * 3. 로직 사용(model 확보)
			ServiceResult result = service.createProd(prod);
			switch (result) {
			case FAIL:
				req.setAttribute("message", "서버 오류, 잠시 뒤 다시 등록하세요.");
				viewName = "prod/prodForm";
				break;
			default:
				viewName = "redirect:/prod/prodDetail.do?what="+prod.getProdId();
				break;
			}
//		 * 4. scope 를 이용해 model 공유
		}else {
			viewName = "prod/prodForm";
		}
//		 * 5. view 결정
//		 * 6. view 로 이동 (flow control)
		
		
		new ViewResolverComposite().resolveView(viewName, req, resp);
		
//		if(viewName.startsWith("redirect:")) {
//			String location = viewName.replace("redirect:", req.getContextPath());
//			resp.sendRedirect(location);
//		}else if(viewName.startsWith("forward:")){
//			String path = viewName.substring("forward:".length());
//			req.getRequestDispatcher(path).forward(req, resp);
//		}else {
//			req.getRequestDispatcher(viewName).forward(req, resp);			
//		}
	}
}	
	



//	private boolean validate(ProdVO prod, Map<String, String> errors) {
//		boolean valid = true;
////		if (StringUtils.isBlank(prod.getProdId())) {
////			valid = false;
////			errors.put("prodId", "상품코드 누락");
////		}
//		if (StringUtils.isBlank(prod.getProdName())) {
//			valid = false;
//			errors.put("prodName", "상품명 누락");
//		}
//		if (StringUtils.isBlank(prod.getProdLgu())) {
//			valid = false;
//			errors.put("prodLgu", "상품분류 누락");
//		}
//		if (StringUtils.isBlank(prod.getProdBuyer())) {
//			valid = false;
//			errors.put("prodBuyer", "거래처 누락");
//		}
//		if (prod.getProdCost()==null) {
//			valid = false;
//			errors.put("prodCost", "구매가 누락");
//		}
//		if (prod.getProdPrice()==null) {
//			valid = false;
//			errors.put("prodPrice", "판매가 누락");
//		}
//		if (prod.getProdSale()==null) {
//			valid = false;
//			errors.put("prodSale", "세일가 누락");
//		}
//		if (StringUtils.isBlank(prod.getProdOutline())) {
//			valid = false;
//			errors.put("prodOutline", "요약정보 누락");
//		}
//		if (StringUtils.isBlank(prod.getProdImg())) {
//			valid = false;
//			errors.put("prodImg", "이미지 누락");
//		}
//		if (prod.getProdTotalstock()==null) {
//			valid = false;
//			errors.put("prodTotalstock", "총재고 누락");
//		}
//		if (prod.getProdProperstock()==null) {
//			valid = false;
//			errors.put("prodProperstock", "적정재고 누락");
//		}
//		return valid;
//	}

