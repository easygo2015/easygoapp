<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<h1> Информация о пользователе </h1>

<div>
  <h2>Логин юзера ${user.login}</h2>

  <h2>Имя пользователя ${user.name}</h2>

  <h2>Мыло пользователя ${user.email}</h2>

  <h2>Телефон пользователя ${user.phoneNumber}</h2>

  <h2>Пароль пользователя ${user.password}</h2>

  <h2>Пол пользователя ${user.gender}</h2>

  <h2>Машина пользователя ${user.car}</h2>

</div>
</body>
</html>
