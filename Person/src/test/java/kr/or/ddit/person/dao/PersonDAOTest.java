package kr.or.ddit.person.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class PersonDAOTest {
	static Validator validator;
	
	@BeforeAll
	static void setUpBeforeClass() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	PersonDAO dao = new PersonDAOImpl();
	
	
	@Test
	void testSelectPersonList() {
		List<PersonVO> personList = dao.selectPersonList();
		log.info("list : {}", personList);
	}

	@Test
	void testSelectPerson() {
		PersonVO person = dao.selectPerson("Z9999");
		log.info("person : {}", person);
	}

	@Test
	void testValidator() {
		PersonVO person = new PersonVO();
		person.setId("A9999");
		person.setName("aTest");
		person.setGender("F");
		person.setAge(11);
		person.setAddress("aTest aTest");
		Set<ConstraintViolation<PersonVO>> violations = validator.validate(person);
		for(ConstraintViolation<PersonVO> single : violations) {
			String personName = single.getPropertyPath().toString();
			String message = single.getMessage();
			log.info("{}; {}", personName, message);
		}
		 boolean valid = violations.isEmpty();
		 log.info("검증 통과 여부 : {}", valid);
		 log.info("검증에 통과하지 못한 프로퍼티 개수 : {}", violations.size());
		
	}
	@Test
	void testInsertPerson() {
		PersonVO person = new PersonVO();
		person.setId("A9989");
		person.setName("aTest");
		person.setGender("F");
		person.setAge(20);
		person.setAddress("aTest aTest");
		int rowcnt = dao.insertPerson(person);
		assertEquals(1, rowcnt);
	}

	@Test
	void testUpdatePerson() {
		PersonVO person = new PersonVO();
		person.setId("A9989");
		person.setName("aaa");
		person.setGender("F");
		person.setAge(20);
		person.setAddress("aTest aTest");
		int rowcnt = dao.updatePerson(person);
		assertEquals(1, rowcnt);
		
	}

	@Test
	void testDeletePerson() {
		PersonVO person = new PersonVO();
		int rowcnt = dao.deletePerson("A9989");
		assertEquals(1, rowcnt);
	}

}
