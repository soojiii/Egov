package kr.or.ddit.case1;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(locations = "classpath:kr/or/ddit/case1/conf/*-context.xml")
class JdbcTemplateTest {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	NamedParameterJdbcTemplate nameParameterJdbcTemplate;
	
	@Test
	void test() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT MEM_ID, MEM_NAME FROM MEMBER");
		list.forEach(m->log.info("element : {}", m));
	}
	
	@Test
	void test2() {
		String sql = "SELECT MEM_ID FROM MEMBER";
		List<String> list = jdbcTemplate.queryForList(sql, String.class);
		list.forEach(m->log.info("element : {}", m));
	}

	@Test
	void test3() {
		String sql = "SELECT MEM_ID, MEM_NAME FROM MEMBER";
		List<MemberVO> list = jdbcTemplate.query(sql, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberVO member = new MemberVO();
				member.setMemId(rs.getString("MEM_ID"));
				member.setMemName(rs.getString("MEM_NAME"));
				return member;
			}
		});
		list.forEach(m->log.info("element : {}", m));
	}
	
	@Test
	void test4() {
		String sql = "SELECT MEM_ID, MEM_NAME FROM MEMBER WHERE MEM_ID = ? AND MEM_NAME = ?";
		MemberVO member =  jdbcTemplate.queryForObject(sql, new Object[] {"a001", "김은대"}, new RowMapper<MemberVO>() {
			@Override
			public MemberVO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberVO member = new MemberVO();
				member.setMemId(rs.getString("MEM_ID"));
				member.setMemName(rs.getString("MEM_NAME"));
				return member;
			}
		});
		log.info("member : {}", member);
	}
	
	@Test
	void test5() {
		String sql = "SELECT MEM_ID, MEM_NAME FROM MEMBER WHERE MEM_ID = :memId AND MEM_NAME = :memName";
//		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
//		parameterSource.addValue("memId", "a001");
//		parameterSource.addValue("memName", "김은대");
		
		MemberVO params = new MemberVO();
		params.setMemId("a001");
		params.setMemName("김은대");
		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(params);
		
		MemberVO member = nameParameterJdbcTemplate.queryForObject(sql, parameterSource, new RowMapper<MemberVO>() {
			@Override
			public MemberVO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberVO member = new MemberVO();
				member.setMemId(rs.getString("MEM_ID"));
				member.setMemName(rs.getString("MEM_NAME"));
				return member;
			}
		});
		
		log.info("member : {}", member);
		
	}
	
}




