package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@SpringJUnitConfig(locations = "classpath:kr/or/ddit/case2/conf/*-context.xml")
@Slf4j
class MemberDAOTest {
	
	@Autowired
	MemberDAO dao;
	
	@Test
	void testSelectMemberList() {
		List<MemberVO> list = dao.selectMemberList();
		log.info("list : {}", list);
	}

	@Test
	void testSelectMember() {
		MemberVO member = dao.selectMember("a001");
		log.info("member : {}", member);
	}

}
