package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProdDAOTest extends AbstractRootContextTest {

	@Autowired
	ProdDAO dao;
	
	@Test
	void testInsertProd() {
		ProdVO prod = dao.selectProd("P101000001");
		prod.setProdId(null);
		int rowcnt = dao.insertProd(prod);
		assertEquals(1, rowcnt);
		log.info("prodId : {}", prod.getProdId());
		
//		prod.setprodId("");
//		prod.setprodName("");
//		prod.setprodLgu("");
//		prod.setprodBuyer("");
//		prod.setprodCost("");
//		prod.setprodPrice("");
//		prod.setprodSale("");
//		prod.setprodOutline("");
//		prod.setprodImg("");
//		prod.setprodTotalstock("");
//		prod.setprodprodProperstock("");
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
