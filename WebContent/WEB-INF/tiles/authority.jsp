
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="<c:url value='/j_spring_security_check' />" method="POST">
<div class="box">
<h1>Authorization Required</h1>

<input type="text" name="j_username" placeholder="username" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />
  
<input type="password" name="j_password" placeholder="password" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />
 Keep me logged in<input type="checkbox" name="_spring_security_remember_me"  />
 
 <input  class="btn" type="submit" name="login" value="login"/>
 
  
</div> 
  
</form>

