package kr.or.ddit.addressBook.service;

import java.util.List;

import kr.or.ddit.addressBook.dao.AddrDAO;
import kr.or.ddit.addressBook.dao.AddrDAOImpl;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.vo.AddrVO;

public class AddrServiceImpl implements AddrService {
	private AddrDAO dao = new AddrDAOImpl();
	
	@Override
	public ServiceResult createAddr(AddrVO addr) {
		ServiceResult result = null;
		
		return null;
	}

	@Override
	public List<AddrVO> retrieveAddrList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddrVO retrieveAddr(int adrsNo) throws PkNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult modifyAddr(AddrVO addr) throws PkNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeAddr(int adrsNo) throws PkNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
