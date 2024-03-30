package kr.or.ddit.addressBook.dao;

import java.util.List;

import kr.or.ddit.vo.AddrVO;

/**
 * 주소록 관리(CRUD)를 위한 Persistence Layer
 *
 */
public interface AddrDAO {

	/**
	 * 주소록 등록
	 * @param addr
	 * @return 등록된 레코드 수
	 */
	public int createAddr(AddrVO addr);
	
	
	/**
	 * 주소록 목록 조회(주소록번호, 소유자, 이름, 휴대푠, 주소)
	 * @return 존재하지 않으면, list.size()==0
	 */
	public List<AddrVO> retrieveAddrList();
	
	
	/**
	 * 주소록 상세 조회(엔터티의 모든 컬럼 조회)
	 * @param adrsNo
	 * @return 존재하지 않으면 null 반환
	 */
	public AddrVO retrieveAddr(int adrsNo);
	
	
	/**
	 * 주소록 정보 수정
	 * @param addr
	 * @return 수정된 레코드 수
	 */
	public int modifyAddr(AddrVO addr);
	
	
	/**
	 * 주소록 정보 삭제
	 * @param adrsNo
	 * @return 삭제된 레코드 수
	 */
	public int removeAddr(int adrsNo);
	
	
}
