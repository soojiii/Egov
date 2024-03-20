<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public String data = "DATA";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>13/pageContextDesc.jsp</title>
</head>
<body>
<h4>pageContext(PageContext)</h4>
<pre>
	기본객체 중 가장 먼저 생성되고, 나머지 기본객체에 대한 참조를 가진 객체.
	<%=request==pageContext.getRequest() %>
	<%=session==pageContext.getRequest() %>
	<%=request.getContextPath() %>, ${pageContext.request.contextPath }
	
	Scope(Map) : 웹어플리케이션에서 공유 데이터를 저장하기 위한 저장소.
		생명주기가 다른 4개의 기본객체가 가진 map.
		scope를 통해서 공유되는 name/value로 구성된 데이터 : attribute
	1. page scope : pageContext 가 관리하는 map
	2. request scope : request 가 관리하는 map
	3. session scope : session 가 관리하는 map
	4. application scope : ServletContext 가 관리하는 map
	
	setAttribute(name, value), getAttribute(name), removeAttribute(name)
	<%
		pageContext.setAttribute("pageAttr", "페이지 속성");
		request.setAttribute("requestAttr", "요청 속성1");
		pageContext.setAttribute("requestAttr2", "요청 속성2", pageContext.REQUEST_SCOPE);
		session.setAttribute("sessionAttr", "세션 속성");
		application.setAttribute("applicationAttr", "어플리케이션 속성");
		
// 		request.getRequestDispatcher("/13/attrView.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/13/attrView.jsp");
	%>

<%-- <!-- 	<a href="<%=request.getContectPath() %>/13/attrView.jsp">속성 확인</a> --> --%>
	
<!-- 	class A{
		public String c;
		B b = new B();
		b.d;
	}
	class B{
		public String d;
		A a = new A();
		a.c; 
	} -->
	
	
</pre>
</body>
</html>