package kr.or.ddit.person.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.PersonVO;

/**
 * 사람정보 관리(CRUD)
 *
 */
public interface PersonDAO {
	
	/**
	 * 사람정보 목록 조회
	 * 아이디, 이름, 성별, 나이, 주소
	 * @return 존재하지 않으면, list.size()==0
	 */
	public List<PersonVO> selectPersonList();
	
	/**
	 * 사람정보 상세 조회
	 * @param id
	 * @return 존재하지 않으면 null 반환
	 */
	public PersonVO selectPerson(@Param("id") String id);
	
	/**
	 * 사람정보 등록
	 * @param person
	 * @return 등록된 레코드 수
	 */
	public int insertPerson(PersonVO person);
	
	/**
	 * 사람정보 수정
	 * @param person
	 * @return 수정된 레코드 수
	 */
	public int updatePerson(PersonVO person);
	
	/**
	 * 사람정보 삭제
	 * @param id
	 * @return 삭제된 레코드 수
	 */
	public int deletePerson(@Param("id") String id);
	
	
}
