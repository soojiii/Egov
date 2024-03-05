<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	int num = 5;
	String numParam = request.getParameter("num");
	if(numParam!=null && !numParam.isEmpty()){
		try{
			num = Integer.parseInt(numParam);
			if(num<0 || num>10) num=5;
		}catch(NumberFormatException e){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
	}
%> --%>

<%
	int num = 5;
	String numStr = request.getParameter("num");
	if(numStr!=null && !numStr.isEmpty()){
		try{
		num = Integer.parseInt(numStr);
	
		}catch(NumberFormatException e){
			response.sendError(400, e.getMessage());
			return;
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <%!
	StringBuffer sigma(int num){
		String si = "<p>%d</p>";
		StringBuffer siTags = new StringBuffer();
		int sum = 0;
		for(int i=1; i<=num; i++){
			sum = sum+i;
		}
		siTags.append(String.format(si, sum));
		return siTags;
	}
%>
<%!
	StringBuffer factorial(int num){
		String fa = "<p>%d</p>";
		StringBuffer faTags = new StringBuffer();
		int mul = 1;
		for(int i=1; i<=num; i++){
			mul = mul*i;
		}
		faTags.append(String.format(fa, mul));
		return faTags;
	}
%> --%>

<body>
<%--재귀호출(함수 내부에서 함수가 자기 자신을 또다시 호출하는 행위) --%>
<%!
	long sigma(int number){
		if(number<1 || number>10)
			throw new IllegalArgumentException("1부터 10사이의 피연산자만 처리 가능.");
		if(number==1) return 1;
		else
			return number + sigma(number-1);
	}
	long factorial(int number){
		if(number<1 || number>10)
			throw new IllegalArgumentException("1부터 10사이의 피연산자만 처리 가능.");
		if(number==1) return 1;
		else
			return number * factorial(number-1);
	}
%>
<form>
	<input type="number" name="num" min="1" max="10" value="<%=num%>"/>
	<button type="submit">전송</button>
</form>
<%
try{
%>
<h4>누적 합 : <%=sigma(num) %></h4>
<h4>누적 곱 : <%=factorial(num) %></h4>
<%
}catch(IllegalArgumentException e){
	response.sendError(400, e.getMessage());
}
%>
</body>
</html>