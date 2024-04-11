package kr.or.ddit.addressbook.service;

import java.util.List;

import kr.or.ddit.vo.AddressBookVO;

public interface AddressBookService {
	public List<AddressBookVO> retrieveAddressBookList();
	public void insertAddressBook(AddressBookVO address);
}
