package kr.or.ddit.addressBook.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.vo.AddrVO;

/**
 * 주소록 관리를 위한 Business Logic Layer(Service Layer)
 *
 */
public interface AddrService {
	
	/**
	 * 주소록 등록
	 * @param addr
	 * @return PKDUPLICATED, OK, FAIL
	 */
	public ServiceResult createAddr(AddrVO addr);
	
	
	/**
	 * 주소록 목록 조회
	 * @return
	 */
	public List<AddrVO> retrieveAddrList();
	
	
	
	/**
	 * 주소록 상세 조회
	 * @param adrsNo
	 * @return
	 * @throws PkNotFoundException(500) 존재하지 않는 경우 예외 발생.
	 */
	public AddrVO retrieveAddr(int adrsNo) throws PkNotFoundException;
	
	
	/**
	 * 주소록 정보 수정
	 * @param addr
	 * @return INVALIDPASSWORD, OK, FAIL
	 * @throws PkNotFoundException(500) 존재하지 않는 경우 예외 발생.
	 */
	public ServiceResult modifyAddr(AddrVO addr) throws PkNotFoundException;
	
	
	/**
	 * 주소록 정보 삭제
	 * @param adrsNo
	 * @return INVALIDPASSWORD, OK, FAIL
	 * @throws PkNotFoundException(500) 존재하지 않는 경우 예외 발생.
	 */
	public ServiceResult removeAddr(int adrsNo) throws PkNotFoundException;
	
}
