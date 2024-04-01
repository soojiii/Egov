package kr.or.ddit.member.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.vo.MemberVO;

class MemberServiceTest {
	
	MemberService service = new MemberServiceImpl();
	
	@Test
	void testCreateMember() {
		fail("Not yet implemented");
	}

	@Test
	void testRetrieveMemberList() {
		fail("Not yet implemented");
	}

	@Test
	void testRetrieveMember() {
		fail("Not yet implemented");
	}

	
	@Test
	void testModifyMember() {
		final MemberVO member = new MemberVO();
		member.setMemId("asssd");
		assertThrows(PkNotFoundException.class, ()->service.modifyMember(member));
		member.setMemId("a001");
		member.setMemPass("aaaa");
		assertEquals(ServiceResult.INVALIDPASSWORD, service.modifyMember(member));
		MemberVO memberOK = service.retrieveMember(member.getMemId());
		assertEquals(ServiceResult.OK, service.modifyMember(memberOK));
	}

	
	@Test
	void testRemoveMember() {
		final MemberVO member = new MemberVO();
		member.setMemId("asssd");
		assertThrows(PkNotFoundException.class, ()->service.removeMember(member));
		member.setMemId("a001");
		member.setMemPass("aaaa");
		assertEquals(ServiceResult.INVALIDPASSWORD, service.removeMember(member));
		member.setMemPass("asdfasdf");
		assertEquals(ServiceResult.OK, service.removeMember(member));
	}

}







