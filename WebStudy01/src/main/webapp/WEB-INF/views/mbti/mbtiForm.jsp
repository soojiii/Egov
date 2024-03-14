<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MBTI</title>
</head>
<body>
    <form id="mbti-form" method="post" enctype="application/x-www-form-urlencoded">
        <select name="type" onchange="this.form.requestSubmit()">
        	<%
        		Map<String, String> mbtiMap = (Map)application.getAttribute("mbtiMap");
        		for(Entry<String, String> entry : mbtiMap.entrySet()){
        			%>
          			  <option value="<%=entry.getKey()%>"><%=entry.getValue()%></option>
        			<%
        		}
        	%>
        </select>
    </form>
    <div id="mbti-area">
    	
    </div>
<script src="<%=request.getContextPath() %>/resources/js/app/mbti/mbtiForm.js"></script>    
</body>
</html>