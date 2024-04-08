package kr.or.ddit.person.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.vo.PersonVO;

/**
 * 사람정보 관리를 위한 business Logic Layer(Service Layer)
 *
 */
public interface PersonService {
	
	/**
	 * 사람정보 목록 조회
	 * @return
	 */
	public List<PersonVO> retrievePersonList();
	
	/**
	 * 사람정보 상세 조회
	 * @param id
	 * @return
	 * @throws PkNotFoundException(500) 존재하지 않는 경우 예외 발생.
	 */
	public PersonVO retrievePerson(String id) throws PkNotFoundException;
	
	/**
	 * 사람정보 등록
	 * @param person
	 * @return PKDUPLICATED, OK, FAIL
	 */
	public ServiceResult createPerson(PersonVO person);
	
	/**
	 * 사람정보 수정
	 * @param person
	 * @return OK, FAIL
	 * @throws PkNotFoundException(500) 존재하지 않는 경우 예외 발생.
	 */
	public ServiceResult modifyPerson(PersonVO person) throws PkNotFoundException;
	
	/**
	 * 사람정보 삭제
	 * @param inputData
	 * @return OK, FAIL
	 * @throws PkNotFoundException(500) 존재하지 않는 경우 예외 발생.
	 */
	public ServiceResult removePerson(String id) throws PkNotFoundException;
	
}
