<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/includee/preScript.jsp" />
</head>
<body>
<form method="post" name="btsForm" enctype="application/x-www-form-urlencoded">
	<select name="member" onchange="this.form.requestSubmit();" required>
		<option value>선택</option>
			<c:forEach items="${btsList }" var="bts">
				<option value="${bts['code']}" label="${bts['name']},${bts['count']}"/>
			</c:forEach>
	</select>
</form>
<div id="result-area">

</div>
<script type="text/javascript">
	document.btsForm.addEventListener("submit", (e)=>{
		e.preventDefault();
		console.log(e.target);
		let form = e.target;
		let url = form.action;
		let method = form.method;
		let headers = {
			"content-type":form.enctype,
			"accept":"text/html"
		}
		let formData = new FormData(form);
		let body = new URLSearchParams(formData).toString();
		fetch(url, {
			method : method,
			headers : headers,
			body:body
		}).then(resp=>resp.text())
		.then(txt=>window['result-area'].innerHTML = txt)
		.catch(e=>console.error(e));
	});
</script>
<jsp:include page="/WEB-INF/includee/postScript.jsp" />
</body>
</html>