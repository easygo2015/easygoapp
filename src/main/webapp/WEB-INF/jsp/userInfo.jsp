<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div class="container">
    <h1 class="center-block" align="center"> Добро пожаловать, ${user.name}! </h1>
    <div class="center-block">
        <h4 align="center">Ваш логин на сервисе ${user.login}</h4>
        <h4 align="center">Теперь Вы можете войти в систему, используя Ваш логин и пароль.</h4>
    </div>
    <a href="/">
        <button type="button" class="btn btn-primary btn-lg btn-block">Вернуться на главную</button>
    </a>
</div>
</body>
</html>
