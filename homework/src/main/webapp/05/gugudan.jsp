<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int minDan = 1;
	int maxDan = 1;
	String minD = request.getParameter("minDan");
	String maxD = request.getParameter("maxDan");
	
	if(minD!=null && !minD.isEmpty() && maxD!=null && !maxD.isEmpty()){
		try{
		minDan = Integer.parseInt(minD);
		maxDan = Integer.parseInt(maxD);
		}catch(NumberFormatException e){
			response.sendError(400, e.getMessage());
			return;
		}
	}
	
	if(minDan>maxDan){
		response.sendError(400, "시작단이 끝단보다 클수없습니다.");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%!
	StringBuffer gugudan(int minDan, int maxDan){
		
		String str = "<td>%d*%d=%d</td>";
		StringBuffer gugu = new StringBuffer(); 
		if(minDan<1||minDan<1)
			throw new IllegalArgumentException("1이상의 피연산자만 처리 가능.");
		else{
			for(int i=minDan; i<=maxDan; i++){
				gugu.append(String.format("<tr><th>%d단</th>",i));
				for(int j=1; j<=9; j++){
					int dan = i*j;
					gugu.append(String.format(str, i, j, dan));
				}
				gugu.append("</tr>");
			}
		}
		return gugu;
	}

%>
<form>
<input type="number" name="minDan" min="1" value="<%=minDan%>"/>
<input type="number" name="maxDan" min="1" value="<%=maxDan%>"/>
<button type="submit">전송</button>
</form>
<%
try{
%>
<table border="1">
		<%=gugudan(minDan, maxDan) %>
</table>
<%
}catch(IllegalArgumentException e){
	response.sendError(400, e.getMessage());
}
%>
</body>
</html>