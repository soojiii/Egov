package kr.or.ddit.case9.obj;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@RequiredArgsConstructor
public class Hunter {
	private final Gun rifleGun;
	@Autowired
	private HuntingDog dog;
	
	public void setDog(HuntingDog dog) {
		this.dog = dog;
	}
	
}



