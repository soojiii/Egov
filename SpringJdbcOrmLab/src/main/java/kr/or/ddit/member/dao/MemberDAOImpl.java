package kr.or.ddit.member.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
//	@Autowired
//	private SqlSessionFactory factory;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertMember(MemberVO member) {
//			int rowcnt = sqlSession.insert("kr.or.ddit.member.dao.MemberDAO.insertMember", member);
			int rowcnt = sqlSession.getMapper(MemberDAO.class).insertMember(member);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
	}

	
	@Override
	public List<MemberVO> selectMemberList() {
//			return sqlSession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
//			return generateProxy(sqlSession).selectMemberList();
			MemberDAO mapperProxy =  sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectMemberList();
	}

	
	@Override
	public MemberVO selectMember(String memId) {
//			return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMember", memId);
//			return generateProxy(sqlSession).selectMember(memId);
			return sqlSession.getMapper(MemberDAO.class).selectMember(memId);
	}

	
	@Override
	public int updateMember(MemberVO member) {
//			int rowcnt = sqlSession.update("kr.or.ddit.member.dao.MemberDAO.updateMember", member);
			int rowcnt = sqlSession.getMapper(MemberDAO.class).updateMember(member);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
	}

	@Override
	public int deleteMember(String memId) {
//			int rowcnt = sqlSession.update("kr.or.ddit.member.dao.MemberDAO.deleteMember", memId);
			int rowcnt = sqlSession.getMapper(MemberDAO.class).deleteMember(memId);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
	}

	@Override
	public MemberVO selectMemberForAuth(String memId) {
			return sqlSession.getMapper(MemberDAO.class).selectMemberForAuth(memId);
	}
}
