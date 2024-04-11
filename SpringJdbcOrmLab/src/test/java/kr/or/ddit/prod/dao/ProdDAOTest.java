package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.AbstractModelContextTest;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProdDAOTest extends AbstractModelContextTest{
	
	@Autowired
	ProdDAO dao;
	
	@Test
	void testSelectProdList() {
		List<ProdVO> list = dao.selectProdList();
		log.info("주입된 dao : {}", dao);
	}

}
