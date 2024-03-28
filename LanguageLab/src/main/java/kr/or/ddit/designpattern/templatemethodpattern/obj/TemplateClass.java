package kr.or.ddit.designpattern.templatemethodpattern.obj;

public abstract class TemplateClass {
	// 반복되는 작업의 순서를 일정하게 제어하는 메소드 : template method
	public final void template() {
		stepOne();
		stepTwo();
		stepThree();
	}
	
	// 실제 작업 단뎨를 담당하고 template method의 제어를 "받는" 메소드 : hook method
	private void stepOne() {
		System.out.println("1단계 실행");
	}
	
	protected abstract void stepTwo();
	
	private void stepThree() {
		System.out.println("3단계 실행");
	}
	
}
