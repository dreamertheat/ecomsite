
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
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
