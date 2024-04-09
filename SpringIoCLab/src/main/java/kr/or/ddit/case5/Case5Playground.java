package kr.or.ddit.case5;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.case5.person.controller.PersonController;
import kr.or.ddit.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case5Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new GenericXmlApplicationContext("classpath:kr/or/ddit/case8/conf/Person-Context.xml");
		context.registerShutdownHook();
		
		PersonController controller =context.getBean(PersonController.class);
		List<PersonVO> list = controller.personListToResponse();
		log.info("list : {}", list);
	}
}
