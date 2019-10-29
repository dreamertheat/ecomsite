
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<sec:authorize access="hasRole('ROLE_OJT')" >OJT<br></sec:authorize>
<sec:authorize access="hasRole('ROLE_STATIC')" >STATIC<br></sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')" >Admin<br></sec:authorize>
<sec:authorize access="isAnonymous()" >Anonymous<br></sec:authorize>
<sec:authorize access="!isAuthenticated()" >Not authenticated<br></sec:authorize>
<sec:authorize access="isAuthenticated()" >Authenticated<br></sec:authorize>
<sec:authorize access="denyAll" >Denied<br></sec:authorize>
<sec:authorize access="permitAll" >**</sec:authorize>
<fmt:message key="Title.page.about"  /><br>
	<c:out value="${about}"></c:out>
	<br>
	<c:out value="${corporation}"></c:out>
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

		<c:forEach items="${service}" var="off">
			<tr>
				<td><c:out value="${off._id}"></c:out></td>
				<td><c:out value="${off.name}"></c:out></td>
				<td><c:out value="${off.description}"></c:out></td>
				<td><c:out value="${off.date}"></c:out></td>
				<td><c:out value="${off.sequence}"></c:out></td>
				<td><a href="${pageContext.request.contextPath}/about?layer=delete_about_${off._id}">delete</a></td>
			</tr>
		</c:forEach>
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