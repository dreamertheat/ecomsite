<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Page</title>
</head>
<body>
	<b>Hello!</b><br> 
	The Current time: <c:out value="${time}"></c:out><br>
	<a href="${pageContext.request.contextPath}/about?layer=main"> ABOUT</a>
</body>
</html>