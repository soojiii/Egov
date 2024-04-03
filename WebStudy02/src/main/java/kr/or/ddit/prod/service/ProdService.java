package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.vo.ProdVO;

/**
 * 상품 관리를 위한 business Logic Layer(Service Layer)
 *
 */
public interface ProdService {
	/**
	 * 
	 * @param prod
	 * @return OK, FAIL
	 */
	public ServiceResult createProd(ProdVO prod);
	
	/**
	 * 상품 목록 조회
	 * @return
	 */
	public List<ProdVO> retrieveProdList();
	
	/**
	 * 상품 상세 조회
	 * @param prodId
	 * @return
	 * @throws PkNotFoundException(500) 존재하지 않는 경우 예외 발생.
	 */
	public ProdVO retrieveProd(String prodId) throws PkNotFoundException;
	
	/**
	 * @param prod
	 * @return OK, FAIL
	 */
	public ServiceResult modifyProd(ProdVO prod);
}
