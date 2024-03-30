package kr.or.ddit.addressBook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.AddrVO;

public class AddrDAOImpl implements AddrDAO {
	
	private SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int createAddr(AddrVO addr) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
		}
		return 0;
	}

	@Override
	public List<AddrVO> retrieveAddrList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddrVO retrieveAddr(int adrsNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyAddr(AddrVO addr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAddr(int adrsNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
