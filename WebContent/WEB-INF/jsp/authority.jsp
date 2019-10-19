<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:700,600' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath}/static/static/css/login.css" rel='stylesheet' type='text/css'>
<script src="${pageContext.request.contextPath}/static/static/js/login.js" type="text/javascript"></script>

</head>
<body>

<form action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
<div class="box">
<h1>Authorization Required</h1>

<input type="text" name="j_username" placeholder="username" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />
  
<input type="password" name="j_password" placeholder="password" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />
 
 <input  class="btn" type="submit" name="login" value="login"/>
 
  
</div> 
  
</form>


  
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js" type="text/javascript"></script>
</body>
</html>