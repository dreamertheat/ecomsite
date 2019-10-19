<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/static/css/common.css" type="text/css" >
</head>
<body>
 <x:out value="${about}"></x:out><br>
 <x:out value="${corporation}"></x:out><br>

<table style="border: solid 1px">

		<tr>
			<td>id</td>
			<td>name</td>
			<td>description</td>
			<td>date</td>
			<td>sequence</td>
		</tr>
		
			<x:forEach items="${service}" var="off">
				<tr>
					<td><x:out value="${off._id}"></x:out></td>
					<td><x:out value="${off.name}"></x:out></td>
					<td><x:out value="${off.description}"></x:out></td>
					<td><x:out value="${off.date}"></x:out></td>
					<td><x:out value="${off.sequence}"></x:out></td>
				</tr>
			</x:forEach>
	</table>

</body>
</html>