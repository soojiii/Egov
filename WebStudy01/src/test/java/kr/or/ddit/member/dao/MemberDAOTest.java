package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.exception.PersistenceException;
import kr.or.ddit.vo.MemberVO;

class MemberDAOTest {
	MemberDAO dao = new MemberDAOImpl();
	
	@Test
	void testInsertMember() {
		MemberVO member = new MemberVO();
		assertThrows(PersistenceException.class, ()->dao.insertMember(member));
		member.setMemId("a002");
		member.setMemPass("java");
		member.setMemName("테스터");
		member.setMemZip("00000");
		member.setMemAdd1("대전 오류");
		member.setMemAdd2("대덕인재개발원");
		member.setMemMail("aa@naver.com");
		member.setMemBir("2024-01-01");
		int rowcnt = dao.insertMember(member);
		assertEquals(1, rowcnt);
		
	}

	@Test
	void testSelectMemberList() {
		List<MemberVO> memberList = dao.selectMemberList();
		assertNotNull(memberList);
		assertNotEquals(0, memberList.size());
		System.out.println(memberList);
	}

	@Test
	void testSelectMember() {
		String memId = "a001";
		MemberVO member = dao.selectMember(memId);
		assertNotNull(member);
		System.out.println(member);
		memId = "asas' OR '1'='1";
		assertNull(dao.selectMember(memId));
	}

	@Test
	void testUpdateMember() {
		MemberVO member = new MemberVO();
		member.setMemPass("c");
		member.setMemName("c");
		member.setMemRegno1("c");
		member.setMemRegno2("c");
		member.setMemBir(null);
		member.setMemZip("c");
		member.setMemAdd1("c");
		member.setMemAdd2("c");
		member.setMemHometel("c");
		member.setMemComtel("c");
		member.setMemHp("c");
		member.setMemMail("c");
		member.setMemJob("c");
		member.setMemLike("c");
		member.setMemMemorial("c");
		member.setMemMemorialday(null);
		member.setMemMileage(null);
		member.setMemDelete("c");
		member.setMemId("a002");
		int rowcnt = dao.updateMember(member);
		assertEquals(1, rowcnt);
		
	}
	
	@Test
	void testDeleteMember() {
		MemberVO member = new MemberVO();
		String memId = "a002";
		int rowcnt = dao.deleteMember(memId);
		assertEquals(1, rowcnt);
	}
	
	
	
	
}


