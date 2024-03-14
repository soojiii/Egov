<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BTS</title>
</head>
<body>
	<form id="bts-form" method="post" enctype="application/x-www-form-urlencoded">
		<select name="name" onchange="this.form.requestSubmit()">
			<%
				Map<String, String> btsMap = (Map) application.getAttribute("btsMap");
				for(Entry<String, String> entry : btsMap.entrySet()){
					%>
						<option value="<%=entry.getKey()%>"><%=entry.getValue()%></option>				
					<%
				}
			%>
		</select>
</form>
<div id="bts-area">
</div>
<script src="<%=request.getContextPath() %>/resources/js/app/bts/btsForm.js"></script>  
</body>
</html>