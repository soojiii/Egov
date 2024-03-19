<%@page import="org.junit.platform.commons.util.StringUtils"%>
<%@page import="org.apache.catalina.Role"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.catalina.users.MemoryUser"%>
<%@page import="java.security.Principal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String message = request.getParameter("message");
// 	if(message!=null && message.isEmpty()){
	if(StringUtils.isNotBlank(message)){
		
%>
<script type="text/javascript">
	alert("<%=message%>");
</script>
<%
	}
%>
</head>
<body>
	<h4>웰컴페이지</h4>
	<%
		MemoryUser principal = (MemoryUser) request.getUserPrincipal();
// 		String authId = (String) session.getAttribute("authId");
// 		if(authId!=null && !authId.isEmpty()){
		if(principal != null){
			StringBuffer roleNames = new StringBuffer();			
			Iterator<Role> roles = principal.getRoles();
			%>
			<%=principal.getName()%>님.[<%=roleNames %>]
			<form name="logoutForm" method="post"></form>
			<a href="<%=request.getContextPath() %>/login/logout.do" onclick="clickHandler(event);">로그아웃</a>
			<script>
				function clickHandler(event){
					event.preventDefault();
					document.logoutForm.action = event.target.href;
					document.logoutForm.requestSubmit();
				}
			</script>
			<%
		}else{
			%>
			<a href="<%=request.getContextPath() %>/login/loginForm.jsp">로그인</a>
			<%
		}
	%>
</body>
</html>