<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Page</title>
</head>
<body>
	<b>Hello!</b>
	<br> The Current time:
	<c:out value="${time}"></c:out>
	<br>
	<a href="${pageContext.request.contextPath}/about?layer=main">
		about</a>
	<br>
	<sec:authorize access="isAuthenticated()">
		<a href="${pageContext.request.contextPath}/j_spring_security_logout">
			logout</a>
	</sec:authorize>
</body>
</html>