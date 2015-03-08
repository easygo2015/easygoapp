<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Login page</h1>

<h1>This is area for all permissions</h1>

<div id="login-box">

  <h3>Login with Username and Password</h3>

  <c:url value="/j_spring_security_check" var="loginUrl"/>
  <form action="${loginUrl}" method="post">
    <h2 class="form-signin-heading">Please sign in</h2>
    <input type="text" class="form-control" name="j_username" required autofocus value="">
    <input type="password" class="form-control" name="j_password" required value="">
    <input type="submit" value="login">
  </form>
</div>


</body>
</html>

