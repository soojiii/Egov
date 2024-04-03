package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ProdVO;

public class ProdDAOImpl implements ProdDAO {
	private SqlSessionFactory factory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int insertProd(ProdVO prod) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			int rowcnt = sqlSession.getMapper(ProdDAO.class).insertProd(prod);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public List<ProdVO> selectProdList() {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			return sqlSession.getMapper(ProdDAO.class).selectProdList();
		}
	}

	@Override
	public ProdVO selectProd(String prodId) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			return sqlSession.getMapper(ProdDAO.class).selectProd(prodId);
		}
	}

	@Override
	public int updateProd(ProdVO prod) {
		try(
				SqlSession sqlSession = factory.openSession();
			){
				int rowcnt = sqlSession.getMapper(ProdDAO.class).updateProd(prod);
				if(rowcnt>0) sqlSession.commit();
				return rowcnt;
			}
	}
	
}
