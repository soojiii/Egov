<%@page import="java.time.ZonedDateTime"%>
<%@page import="java.util.Date"%> 
<%@page import="javax.xml.crypto.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="refresh" content="5;url=https://www.naver.com"> -->
<title>08/respsonseDesc.jsp</title>
</head>
<body>
<h4>Http redponse packaging</h4>
<h4>Http 의 기본 특성 : ConnectLess, StateLess</h4>
<pre>
	1. Response Line : 요청 처리 결과를 표현하는 세자리 숫자(status code)
		1) 1XX : ING..., websocket 에서 한정적으로 사용되는 상태코드.
		2) 2XX : 200(OK)
		3) 3XX : 아직 처리가 완료되지 않았으므로, 클라이언트의 추가 액션이 필요함.
				: response body가 없고, 연관된 헤더가 함께 전송됨.
				
				302/307 : MOVED, 이동한 후의 주소를 응답과 함께 전송함(Location 헤더).
				304 : Not Modified
					브라우저의 캐싱 정책과 연관된 상태코드로 정적자원이 캐싱되어있는 경우, 캐싱 자원의 유효 여부를 알려줄때 사용됨.
					 	
		실패를 표현하는 상태코드
		4) 4XX : 클라이언트측 원인으로 처리 실패
			404 : <%=HttpServletResponse.SC_NOT_FOUND %>, 사용자의 URL 식별이 잘못됐을때 발생
			400 : <%=HttpServletResponse.SC_BAD_REQUEST %>, 사용자의 요청을 검증하는 과정에서 주로 발생함.
					ex) 필수파라미터 누락, 잘못된 데이터 타입 전송, 잘못된 데이터 길이... 등을 검증할때 직접 발생시킴.
			405 : <%=HttpServletResponse.SC_METHOD_NOT_ALLOWED %>,
					서블릿 기본 요청 콜백에 정의된 상태코드로 재정의하기 전까지 기본 전송되는 상태코드.
			401/403(보안처리를 위한 접근제어 구조에 사용됨.) :
					 <%=HttpServletResponse.SC_UNAUTHORIZED %>, 인증되지 않은 사용자를 표현할때 발생시킴.
					 <%=HttpServletResponse.SC_FORBIDDEN %>, 인가되지 않은 사용자를 표현할때 발생시킴.		
			406 : <%=HttpServletResponse.SC_NOT_ACCEPTABLE %>,
					accept 요청 헤더로 표현된 response content-type을 처리할 수 없을때 발생시킴.
			415 : <%=HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE %>
					content-type 헤더와 함께 전송된 request body 를 해석할 수 없을때 발생시킴.
		5) 5XX : 서버측의 원인으로 요청 처리 실패
		
		response.setStatus, sendError
		
	2. Response Header : response meta data 영역 (name/value로 구성되는 문자열)
	<%-- 	<%
			response.setHeader("Content-Type", "text/plain");
			response.setIntHeader("Content-Length", 100);
			response.setDateHeader("Date", new Date().getTime());
		%> --%>
	
		1) Content-Type, Content-Length : response body 를 통해 전송되는 컨텐츠를 수식하는 표현.
			ex) Content-Type : text/html
		2) Cache-Control(HTTP 1.1) : 캐시 데이터 제어에 사용되는 헤더
			브라우저의 캐싱 정책을 제어할 수 있는 디렉티브 종류
			- no-cache : 캐싱을 하지말되, 저장된 캐싱데이터가 있는 경우, 확인 후 사용하도록 유도할때.
			- no-store : 캐싱을 하지않도록 유도할때.
			- must-revalidate : 매요청시마다 현재 캐싱된 자원에 대한 확인을 받도록 유도할때.
			- max-age : 캐시 데이터 유효 기간을 초단위로 설정.
			Pragma(HTTP 1.0) : Cache-control 헤더와 용도 동일.
			Expires : 구체적인 캐시데이터의 만료시간을 설정할때.
			
		<%-- 	<%
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				response.setHeader("Pragma", "no-cache, no-store, must-revalidate");
				response.setDateHeader("Expires", 0);
													// "no-cache", "no-store", "must-revalidate",
													// "private","public","max-age=100"
			%> --%>
			
		3) Refresh : 서버상의 주기적으로 갱신되는 자원이 있는 경우, 해당 자원에 대한 자동 요청을 발생시킬때(초단위)
					document 전체를 갱신하는 document 타입의 동기 요청에서만 작동함.
			현재 서버의 시간 : <span id="time-area"></span>
			<%-- <%
				response.setIntHeader("Refresh", 1);
			%> --%>
		4) Location
			<%
// 				response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
// 				response.setHeader("Location", request.getContextPath() + "/08/calendar.jsp");
				response.sendRedirect(request.getContextPath()+"/08/calendar.jsp");
			%>
		
	3. Response Body(Content Body, Message Body) : 응답 본문(content)가 기록되는 영역
	
	
</pre>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", (e)=>{
		/* setInterval(() => {
			fetch("serverTime.jsp",{
				headers:{
					"accept":"text/plain"
				}
			}).then(resp=>{
				if(resp.ok){
					return resp.text();
				}
			}).then(plain=>document.querySelector("#time-area").innerHTML=plain);
		}, 1000); */
	});
</script>
</body>
</html>