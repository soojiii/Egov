package kr.or.ddit.addressbook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AddressBookVO;

@Mapper
public interface AddressBookDAO {
	public List<AddressBookVO> selectAddressBookList();
	public int insertAddressBook(AddressBookVO address);
}
