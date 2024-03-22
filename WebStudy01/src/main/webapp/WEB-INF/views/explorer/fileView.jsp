<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.folder{
		text-decoration: underline;
		color : blue;	
	}
</style>
</head>
<body>
<ul>
	<c:forEach items="${fileList }" var="singleMap">
		<c:set value="${singleMap.file }" var="single"/>
		<li id="${singleMap.path }" class="${single.file ? 'file' : 'folder' }">${single.name }</li>
	</c:forEach>
</ul>
<ul>
	<c:forEach items="${fileMap }" var="entry">
		<c:set value="${entry.value }" var="single"/>
		<li id="${entry.key }" class="${single.file ? 'file' : 'folder' }">${single.name }</li>
	</c:forEach>
</ul>
</body>
</html>