<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>EasyGo</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <!-- CSS
  ================================================== -->
</head>
<body>
<div class="container">
  <div class="col-lg-8 col-md-7 col-sm-6 col-xs-6">
    <div>
      <img class="img-rounded" src="/assets/img/failed.jpg">
    </div>

    <h1>Неверный логин или пароль</h1>

    <h3>Или Вы просто не зарегестрированы</h3>

    <a class="btn btn-primary" href="/">На главную</a>

  </div>
</div>
</body>
</html>
