<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int max = 10;
	String maxParam = request.getParameter("max");
	if(maxParam!=null && !maxParam.isEmpty()){
	try{	
		max = Integer.parseInt(maxParam);
		if(max<0)
			max = 10;
	}catch(NumberFormatException e){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.odd{
		background-color: yellow;
	}
	.even{
		background-color: red;
	}
</style>
</head>
<%!
	StringBuffer printNumber(int max){
		String liPtrn = "<li class='%s'>%d</li>";
		StringBuffer liTags = new StringBuffer();
		for(int i=1; i<=max; i++){
			boolean odd = i%2 ==1;
			String clzValue = odd?"odd" : "even";
			liTags.append(String.format(liPtrn, clzValue, i));
		}
		return liTags;
	}

%>
<body>
<a href="?max=5">더미</a>
<img src=""/>
<form>
<input type="number" name="max" value="<%=max%>"/>
<button type="submit">전송</button>
</form>

<!-- 	max 파라미터를 받고, 해당 파라미터 만큼 li 태그를 반복 생성. -->
<!-- 	단, 파라미터가 없거나, 음수로 전달된 경우, 기본 10개의 li태그 생성. -->
	<ul>
	<%=printNumber(max) %>
	</ul>
</body>
</html>

