package kr.or.ddit.case2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.or.ddit.case1.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component("foo1")
@RequiredArgsConstructor
@ToString
public class Foo {
	private final Bar bar;	//required
	private final SampleService service;
	@Autowired
	private Baz baz;	//optional
	
	
	public void setBaz(Baz baz) {
		this.baz = baz;
	}
	
}
