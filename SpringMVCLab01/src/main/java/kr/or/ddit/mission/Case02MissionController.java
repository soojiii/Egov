package kr.or.ddit.mission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mission/case02")
public class Case02MissionController {
	
	public void handler(
			@RequestHeader(name="user-agent") String agent, 
			@CookieValue(required = false, defaultValue= "1000") int myCookie
	) {
		
	}
}
