package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.ProdVO;

/**
 * 상품관리(CRUD)
 * 
 *
 */
@Mapper
public interface ProdDAO {
	/**
	 * 상품 등록
	 * @param prod
	 * @return 등록된 레코드 수
	 */
	public int insertProd(ProdVO prod);
	/**
	 * 상품 목록 조회
	 * 상품코드, 거래처코드(거래처명), 분류코드(분류명), 상품명, 구매가, 판매가, 마일리지, 입고일자
	 * @return 존재하지 않으면, list.size()==0
	 */
	public List<ProdVO> selectProdList();
	/**
	 * 상품 상세 조회
	 * @param prodId
	 * @return 존재하지 않으면 null 반환
	 */
	public ProdVO selectProd(@Param("prodId") String prodId);
	/**
	 * 상품 수정
	 * @param prod
	 * @return 수정된 레코드 수
	 */
	public int updateProd(ProdVO prod);
}
