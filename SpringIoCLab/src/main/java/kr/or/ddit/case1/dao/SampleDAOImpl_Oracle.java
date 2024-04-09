package kr.or.ddit.case1.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;

@Repository("daoOracle")
@Slf4j
public class SampleDAOImpl_Oracle implements SampleDAO {
	private Map<String, SampleVO> oracleDB;
	{
		oracleDB = new LinkedHashMap<>();
		oracleDB.put("T001", SampleVO.builder()
								.id("T001")
								.name("정성윤_Oracle")
								.role("PL")
								.build());
		oracleDB.put("T002", SampleVO.builder()
								.id("T002")
								.name("장민우_Oracle")
								.role("TA")
								.build());
		oracleDB.put("T003", SampleVO.builder()
								.id("T003")
								.name("신의정_Oracle")
								.role("UA")
								.build());
		oracleDB.put("T004", SampleVO.builder()
								.id("T004")
								.name("박승준_Oracle")
								.role("AA")
								.build());
	}
	
	@Override
	public List<SampleVO> selectSampleList() {
		return new ArrayList<SampleVO>(oracleDB.values());
	}

	@Override
	public SampleVO selectSample(String id) {
		return oracleDB.get(id);
	}
	
	public SampleDAOImpl_Oracle() {
		super();
		log.info("{} 객체생성", this. getClass().getSimpleName());
	}

}
