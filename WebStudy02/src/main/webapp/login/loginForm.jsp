<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
String message = (String)session.getAttribute("message");
if(message!=null && !message.isEmpty()){
	session.removeAttribute("message"); //flash attribute
%>
<script type="text/javascript">
	alert("<%=message%>");
</script>
<%
}
%>
</head>
<body>
<form action="j_security_check" method="post" enctype="application/x-www-form-urlencoded">
	<%
		String paramId = Optional.ofNullable(request.getParameter("memId"))
								.orElse("");
	%>
	<input type="text" name="j_username" placeholder="아이디" value="<%=paramId%>"/>
	<input type="password" name="j_password" placeholder="비밀번호"/>
	<button type="submit">로그인</button>
</form>
</body>
</html>