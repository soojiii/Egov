package kr.or.ddit.enumpkg;

public enum calculateEnum {
	PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

	private calculateEnum(String operator) {
		this.operator = operator;
	}
	
	private String operator;	
	public String getoperatorName() {
		return operator;
	}
	
	public static calculateEnum findoperator(String op) {
		calculateEnum finded = null;
		for(calculateEnum single : values()) {
			if(op.toUpperCase().contains(single.name())) {
				finded = single;
				break;
			}
		}
		return finded;
	}
	
	public static String findoperatorName(String op) {
		return findoperator(op).getoperatorName();
	}
}
