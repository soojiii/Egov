<%@page import="kr.or.ddit.vo.PersonVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 웹에서 기본 컨텐츠 타입으로 사용되는 HTML 컨텐츠를 생성하기 위한 view layer --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#mdiv{
  display : flex;
  flex-direction : row;
}
#dleft,#dright{
  flex : 50%;
}
</style>
</head>
<body>
<div id="mdiv">
	<div id="dleft">
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<PersonVO> people = (List) request.getAttribute("people");
					for(PersonVO once : people){
						%>
						<tr>
							<td><%=once.getId() %></td>
							<td><a href="javascript:;" onclick="clickHandler(event);" data-member-id="<%=once.getId()%>"><%=once.getName() %></a></td>
						</tr>
						<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div id="dright">
	오른쪽
	</div>
</div>

<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/person.js"></script>

</body>
</html>


