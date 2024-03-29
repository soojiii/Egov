package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.ConnectionFactory_HikariCP;
import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	
	private SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insertMember(MemberVO member) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			int rowcnt = sqlSession.insert("kr.or.ddit.member.dao.MemberDAO.insertMember", member);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
		}
	}

	
	@Override
	public List<MemberVO> selectMemberList() {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			return sqlSession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
		}
	}

	
	@Override
	public MemberVO selectMember(String memId) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMember", memId);
		}
	}

	
	@Override
	public int updateMember(MemberVO member) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			int rowcnt = sqlSession.update("kr.or.ddit.member.dao.MemberDAO.updateMember", member);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int deleteMember(String memId) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			int rowcnt = sqlSession.update("kr.or.ddit.member.dao.MemberDAO.deleteMember", memId);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
		}
	}
}
