<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form method="post" enctype="application/x-www-form-urlencoded">
	<table class="table table-bordered">

		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" required value="${person.id}"
				class="form-control" /><span class="text-danger">${errors.id}</span></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" required
				value="${person.name}" class="form-control" /><span
				class="text-danger">${errors.name}</span></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><input type="text" name="gender" required
				value="${person.gender}" class="form-control" /><span
				class="text-danger">${errors.gender}</span></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="number" name="age" required
				value="${person.age}" class="form-control" /><span
				class="text-danger">${errors.age}</span></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" value="${person.address}"
				class="form-control" /><span class="text-danger">${errors.address}</span></td>
		</tr>
		<tr>
			<td colspan="2">
					<button type="submit">저장</button>
					<button type="reset">취소</button>
			</td>
		</tr>
	</table>
</form>