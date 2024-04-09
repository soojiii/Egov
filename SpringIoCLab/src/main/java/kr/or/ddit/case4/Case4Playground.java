package kr.or.ddit.case4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;

import kr.or.ddit.case4.bts.service.BtsService;
import kr.or.ddit.vo.BtsVO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Setter
public class Case4Playground {
	@Autowired
	private BtsService service;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new GenericXmlApplicationContext("classpath:kr/or/ddit/case8/conf/Bts-Context.xml");
		Case4Playground controller = context.getBean("case4Playground", Case4Playground.class);
		
		List<BtsVO> btsList = controller.service.readBtsList();
		log.info("btsList : {}", btsList);
	}
}
