package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.LprodVO;

@Mapper
public interface LprodDAO {
	
	/**
	 * 상품분류 목록 조회
	 * @return
	 */
	public List<LprodVO> selectLprodList();
}
