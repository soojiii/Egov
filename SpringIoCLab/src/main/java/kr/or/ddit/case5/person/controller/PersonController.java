package kr.or.ddit.case5.person.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.or.ddit.case5.person.service.PersonService;
import kr.or.ddit.vo.PersonVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PersonController {
	private final PersonService service;
	
	@PostConstruct
	public void init() {
		log.info("주입이 완료된 객체 : {}", service.getClass().getSimpleName());
	}
	
	public List<PersonVO> personListToResponse(){
		return service.retrievePersonList();
	}
}
