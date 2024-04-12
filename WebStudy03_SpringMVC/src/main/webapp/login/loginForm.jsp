<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	<c:if test="${not empty message }">
		alert("${message}");
		<c:remove var="message" scope="session"/>
	</c:if> 
</script>
<%-- <%
String message = (String)session.getAttribute("message");
if(message!=null && !message.isEmpty()){
	session.removeAttribute("message"); //flash attribute
%>
<script type="text/javascript">
	alert("<%=message%>");
</script>
<%
}
%> --%>
</head>
<body>
<form action="<c:url value='/login/loginProcess.do' />" method="post" enctype="application/x-www-form-urlencoded">
	<%
		String paramId = Optional.ofNullable(request.getParameter("memId"))
								.orElse("");
	%>
	<input type="text" name="memId" placeholder="아이디" />
	<input type="password" name="memPass" placeholder="비밀번호"/>
	<button type="submit">로그인</button>
</form>
</body>
</html>