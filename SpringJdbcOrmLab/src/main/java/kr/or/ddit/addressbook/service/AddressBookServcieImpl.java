package kr.or.ddit.addressbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.addressbook.dao.AddressBookDAO;
import kr.or.ddit.vo.AddressBookVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressBookServcieImpl implements AddressBookService {
	private final AddressBookDAO dao;
	
	@Override
	public List<AddressBookVO> retrieveAddressBookList() {
		return dao.selectAddressBookList();
	}
	@Override
	public void insertAddressBook(AddressBookVO address) {
		dao.insertAddressBook(address);
	}
}
