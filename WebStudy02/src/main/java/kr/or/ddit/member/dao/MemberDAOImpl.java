package kr.or.ddit.member.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	
	private SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	private MemberDAO generateProxy(SqlSession sqlSession) {
		return (MemberDAO) Proxy.newProxyInstance(MemberDAO.class.getClassLoader(), new Class[] {MemberDAO.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// sqlSession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
				String namespace = method.getDeclaringClass().getName();
				String id = method.getName();
				String statement = namespace + "."+id;
				Object argument = null;
				
				if(args!=null && args.length>0) {
					argument = args[0];
				}
				
				if(method.getReturnType().equals(List.class)) {
					return sqlSession.selectList(statement, argument);
				}else {
					return sqlSession.selectOne(statement, argument);
				}
			}
		});
	}
	
	@Override
	public int insertMember(MemberVO member) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
//			int rowcnt = sqlSession.insert("kr.or.ddit.member.dao.MemberDAO.insertMember", member);
			int rowcnt = sqlSession.getMapper(MemberDAO.class).insertMember(member);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
		}
	}

	
	@Override
	public List<MemberVO> selectMemberList() {
		try(
			SqlSession sqlSession = factory.openSession();
		){
//			return sqlSession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
//			return generateProxy(sqlSession).selectMemberList();
			MemberDAO mapperProxy =  sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectMemberList();
		}
	}

	
	@Override
	public MemberVO selectMember(String memId) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
//			return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMember", memId);
//			return generateProxy(sqlSession).selectMember(memId);
			return sqlSession.getMapper(MemberDAO.class).selectMember(memId);
		}
	}

	
	@Override
	public int updateMember(MemberVO member) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
//			int rowcnt = sqlSession.update("kr.or.ddit.member.dao.MemberDAO.updateMember", member);
			int rowcnt = sqlSession.getMapper(MemberDAO.class).updateMember(member);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int deleteMember(String memId) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
//			int rowcnt = sqlSession.update("kr.or.ddit.member.dao.MemberDAO.deleteMember", memId);
			int rowcnt = sqlSession.getMapper(MemberDAO.class).deleteMember(memId);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public MemberVO selectMemberForAuth(String memId) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			return sqlSession.getMapper(MemberDAO.class).selectMemberForAuth(memId);
		}
	}
}
