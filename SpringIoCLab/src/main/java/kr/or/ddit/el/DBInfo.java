package kr.or.ddit.el;

import lombok.Setter;

@Setter
public class DBInfo {
	private String driverClassName;
	private String url;
	private String user;
	private String password;
	
	private int maxActive;
	private int maxIdle;
	private long maxWait;
	private String testQuery;
	
}
