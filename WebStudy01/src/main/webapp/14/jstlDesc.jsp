<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14/jstlDesc.jsp</title>
</head>
<body>
<h4>JSTL(Jsp Standard Tag Library)</h4>
<pre>
	: 커스텀 태그 라이브러리
	*** 커스텀 태그 로딩이 필요함.&lt;%@taglib uri="태그식별" prefix="namespace" %&gt;
	&lt;namespace:tagname attribute_name="attribute_value"&gt;
	** Core 태그(c태그)
	1. EL변수(속성) 지원 : set, remove
 		<c:set var="dummy" value="TEXT" scope="session"/>
		${dummy }
		<%-- <c:remove var="dummy" scope="session"/>  --%> <!-- //flash attribute -->
		${dummy }
		<c:set var="dummyClone" value="${not empty dummy ? dummy : 'default' }" />
		${dummyClone }
		
	2. 조건문 : if, choose_when_otherwise
		<c:if test="${not empty dummy }">
			${dummy }
		</c:if>
		<c:if test="${empty dummy }">
			default
		</c:if>
		
		<c:choose>
			<c:when test="${not empty dummy }">
				${dummy }
			</c:when>
			<c:otherwise>
				default
			</c:otherwise>
		</c:choose>
		
	3. 반복문 : forEach, forTokens
		for(선언절; 조건절; 증감절)
		<c:forEach var="i" begin="1" step="2" end="5" varStatus="vs">
			첫번째 반복문 여부 : ${vs.first }
			마지막 반복문 여부 : ${vs.last }
			몇번재 반복문 : ${vs.count }
			${i }
		</c:forEach>
		토큰?
		intnumber=3;
		int number = 3;
		아버지가 방에 들어가신다
		아버지 가방에 들어가신다
		<c:forTokens items="아버지 가방에 들어가신다" delims=" " var="token">
			${token }
		</c:forTokens>
		<c:set var="numbers" value="1,2,3,4,5" />
		<c:forTokens items="${numbers }" delims="," var="num">
			${num*100 }
		</c:forTokens>
	4. 흐름제어용 : redirect
		<%-- <c:redirect ur="/14/elDesc.jsp" /> --%>
	
	5. 기타 : url, out, import
		<c:url value="/14/elDesc.jsp" var="elDesc">
			<c:param name="q1" value="v1" />
			<c:param name="q2" value="v2" />
		</c:url>
		${elDesc }
		<c:out value="<h4>출력텍스트</h4>" escapeXml="false"/>
		
		<c:set var="htmlSource" value="<h4>출력텍스트</h4>" />
		<c:out value="${htmlSource }" escapeXml="false" />
</pre>
<c:import url="https://www.naver.com" var="naver"/>
<c:out value="${naver }" escapeXml="false"/>
</body>
</html>




