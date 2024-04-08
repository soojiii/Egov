<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-bordered table-stripe">
	<tr>
		<th>아이디</th>
		<td>${person.id}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${person.name}</td>
	</tr>
	<tr>
		<th>성별</th>
		<td>${person.gender}</td>
	</tr>
	<tr>
		<th>나이</th>
		<td>${person.age}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${person.address}</td>
	</tr>
</table>
	<c:url value="/person/personUpdate.do" var="updateUrl" >
		<c:param name="who" value="${person.id}" /> 
	</c:url>
	<button onclick="location.href='${updateUrl}';" class="btn btn-primary">정보 수정</button>
<div>
	<c:url value="/person/personDelete.do" var="deletelUrl">
		<c:param name="who" value="${person.id }" />
	</c:url>
	<form method="post" action="${deletelUrl }">
	<button type="submit" class="btn btn-danger" id="btn">정보 삭제</button>
	</form>
</div>



