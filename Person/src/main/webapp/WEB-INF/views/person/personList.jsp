<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
#mdiv{
  display : flex;
  flex-direction : row;
}
#dleft,#dright{
  flex : 50%;
}
</style>
<div id="mdiv">
	<div id="dleft">
		<td colspan="2">
		<c:url value="/person/personInsert.do" var="insertUrl" >
			<c:param name="who" value="${person.id}" /> 
		</c:url>
		<button onclick="location.href='${insertUrl}';" class="btn btn-primary">사람정보 등록</button>
		</td>
		<table class="table table-bordered table-stripe">
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty personList }">
					<c:forEach items="${personList }" var="person">
						<tr>
							<td>
								${person.id }
							</td>
							<td>
								<a href="javascript:;" onclick="clickHandler(event);" data-person-id="${person.id }">${person.name }</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty personList }">
					<tr>
						<td colspan="2">사람정보 없음</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
	<div id="dright">
	</div>
</div>

<script src="<c:url value='/resources/js/app/person/personDetail.js'/>"></script>

