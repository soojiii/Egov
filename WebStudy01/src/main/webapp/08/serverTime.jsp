<%@page import="java.time.ZonedDateTime"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	response.setIntHeader("Refresh", 1);
%>
<%=ZonedDateTime.now() %>