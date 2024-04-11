package kr.or.ddit.person.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.or.ddit.AbstractModelContextTest;
import kr.or.ddit.person.controller.PersonController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class PersonDAOTest extends AbstractModelContextTest{
	
	@Autowired
	PersonController controller;	

	@Test
	void testSelectPersonList() {
		controller.personListToResponse().forEach(p->log.info("person : {}", p));
	}
	

}
