<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<%-- <jsp:include page="/WEB-INF/includee/preScript.jsp" /> --%>
<!-- </head> -->
<!-- <body> -->

<h4></h4>
<table class="table table-bordered table-stripe">
	<thead class="table-dark">
		<tr>
			<th>상품명</th>
			<th>분류명</th>
			<th>거래처명</th>
			<th>구매가</th>
			<th>판매가</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty prodList }">
			<c:forEach items="${prodList }" var="prod">
				<tr>
					<td>
						<!-- /prod/prodDetail.do?what=P101000001 -->
						<c:url value="/prod/prodDetail.do" var="detailUrl">
							<c:param name="what" value="${prod.prodId }" />
						</c:url>
						<a href="${detailUrl }">${prod.prodName }</a>
					</td>
					<td>${prod.lprod.lprodNm }</td>
					<td>${prod.buyer.buyerName}</td>
					<td>${prod.prodCost }</td>
					<td>${prod.prodPrice }</td>
					<td>${prod.prodMileage }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty prodList }">
			<tr>
				<td colspan="6">상품 없음.</td>
			</tr>
		</c:if>
	</tbody>
</table>

<%-- <jsp:include page="/WEB-INF/includee/postScript.jsp" /> --%>
<!-- </body> -->
<!-- </html> -->