<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About </title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/static/css/common.css"
	type="text/css">
</head>
<body>
<sec:authorize access="isAnonymous()" >Anonymous</sec:authorize>
<sec:authorize access="!isAuthenticated()" >Not authenticated</sec:authorize>
<sec:authorize access="isAuthenticated()" >Authenticated</sec:authorize>
<sec:authorize access="denyAll" >Denied</sec:authorize>
<sec:authorize access="permitAll" >**</sec:authorize>
<fmt:message key="Title.page.about"  /><br>
	<x:out value="${about}"></x:out>
	<br>
	<x:out value="${corporation}"></x:out>
	<br>



	<table style="border: solid 1px">

		<tr>
			<td>id</td>
			<td>name</td>
			<td>description</td>
			<td>date</td>
			<td>sequence</td>
			<td>delete</td>
		</tr>

		<x:forEach items="${service}" var="off">
			<tr>
				<td><x:out value="${off._id}"></x:out></td>
				<td><x:out value="${off.name}"></x:out></td>
				<td><x:out value="${off.description}"></x:out></td>
				<td><x:out value="${off.date}"></x:out></td>
				<td><x:out value="${off.sequence}"></x:out></td>
				<td><a href="${pageContext.request.contextPath}/about?layer=delete_about_${off._id}">delete</a></td>
			</tr>
		</x:forEach>
	</table>




	<%-- <form method="post" commandName="AboutModel" action="${pageContext.request.contextPath}/about&add=true">
		<table style="border: solid 1px">

			<tr>
				<td>name</td>
				<td><input type="text" placeholder="name" name="name" path="name"></input></td>
			</tr>
			<tr>
				<td>description</td>
				<td><input type="text" placeholder="description" name="description" path="description"></td>
			</tr>
			<tr>
				<td>sequence</td>
				<td><input type="text" placeholder="sequence" name="sequence" path="sequence"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="submit" ></td>
			</tr>

		</table>
	</form> --%>

	<f:form method="POST" commandName="aboutModel"
		modelAttribute="aboutModel"
		action="${pageContext.request.contextPath}/about?layer=add_about">
		<table style="border: solid 1px">

			<tr>
				<td><f:label path="name">name</f:label></td>
				<td><f:input type="text" placeholder="name" name="name"
						path="name"></f:input></td>
				<td><f:errors path="name"></f:errors>&nbsp;</td>
			</tr>
			<tr>
				<td>description</td>
				<td><f:input type="text" placeholder="description"
						name="description" path="description"></f:input></td>
				<td><f:errors path="description"></f:errors>&nbsp;</td>
			</tr>
			<tr>
				<td>sequence</td>
				<td><f:input type="text" placeholder="sequence" name="sequence"
						path="sequence"></f:input></td>
				<td><f:errors path="sequence"></f:errors>&nbsp;</td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="submit"></td>
			</tr>

		</table>
	</f:form>

</body>
</html>