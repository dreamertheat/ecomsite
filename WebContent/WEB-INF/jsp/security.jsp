<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/static/css/common.css" type="text/css" >
</head>
<body>
#######


<sql:query var="rs" dataSource="jdbc/springboot">
select * from users
</sql:query>



  <h2>Results</h2>

<c:forEach var="row" items="${rs.rows}">
    ${row._id}<br/>
    ${row.first_name}<br/>
    ${row.last_name}<br/>
    ${row.address}<br/>
    ${row.birthdate}<br/>
    ${row.username}<br/>
</c:forEach>

 
######
</body>
</html>