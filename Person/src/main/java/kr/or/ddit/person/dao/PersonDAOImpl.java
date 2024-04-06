package kr.or.ddit.person.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.PersonVO;

public class PersonDAOImpl implements PersonDAO{
	private SqlSessionFactory factory =
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<PersonVO> selectPersonList() {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			return sqlSession.getMapper(PersonDAO.class).selectPersonList();
		}
	}

	@Override
	public PersonVO selectPerson(String id) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			return sqlSession.getMapper(PersonDAO.class).selectPerson(id);
		}
	}

	@Override
	public int insertPerson(PersonVO person) {
		try(
			SqlSession sqlSession = factory.openSession();
		){
			int rowcnt = sqlSession.getMapper(PersonDAO.class).insertPerson(person);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int updatePerson(PersonVO person) {
		try(
				SqlSession sqlSession = factory.openSession();
			){
				int rowcnt = sqlSession.getMapper(PersonDAO.class).updatePerson(person);
				if(rowcnt>0) sqlSession.commit();
				return rowcnt;
			}
	}

	@Override
	public int deletePerson(String id) {
		try(
				SqlSession sqlSession = factory.openSession();
			){
				int rowcnt = sqlSession.getMapper(PersonDAO.class).deletePerson(id);
				if(rowcnt>0) sqlSession.commit();
				return rowcnt;
			}
	}

}
