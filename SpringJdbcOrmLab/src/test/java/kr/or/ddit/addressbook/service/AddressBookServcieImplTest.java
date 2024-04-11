package kr.or.ddit.addressbook.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.AbstractModelContextTest;
import kr.or.ddit.vo.AddressBookVO;

@Transactional // AOP 방법에 따른 트랜잭션 관리
class AddressBookServcieImplTest extends AbstractModelContextTest{
	
	@Autowired
	AddressBookService service;

	@Test
	void testRetrieveAddressBookList() {
		service.retrieveAddressBookList();
	}

	@Test
	void testInsertAddressBook() {
		AddressBookVO address = new AddressBookVO();
		address.setMemId("a001");
		address.setAdrsAdd("대전 중구2");
		address.setAdrsName("대덕인재개발원2");
		address.setAdrsTel("00-000-00002");
		service.insertAddressBook(address);
	}

}
