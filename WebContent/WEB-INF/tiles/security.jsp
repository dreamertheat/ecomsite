
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
