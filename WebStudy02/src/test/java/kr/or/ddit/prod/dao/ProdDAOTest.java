package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProdDAOTest {

	ProdDAO dao = new ProdDAOImpl();
	
	@Test
	void testInsertProd() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectProdList() {
		List<ProdVO> prodList = dao.selectProdList();
		log.info("list: {}", prodList);
	}

	@Test
	void testSelectProd() {
		ProdVO prod = dao.selectProd("P101000001");
		log.info("prod : {}", prod);
	}

	@Test
	void testUpdateProd() {
		fail("Not yet implemented");
	}

}
