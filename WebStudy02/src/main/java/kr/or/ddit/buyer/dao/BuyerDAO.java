package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.BuyerVO;

public interface BuyerDAO {
//	insert
	/**
	 * 거래처 목록
	 * 거래처아이디, 거래처명, 분류코드(분류명), 소재지, 담당자명, 전화번호
	 * @return 존재하지 않으면, list.size()==0
	 */
	public List<BuyerVO> selectBuyerList();
	/**
	 * 거래처 상세 조회
	 * @param buyerId
	 * @return 존재하지 않으면 null 반환
	 */
	public BuyerVO selectBuyer(@Param("buyerId") String buyerId);
//	update
}
