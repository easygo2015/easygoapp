<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="jumbotron col-lg-12 col-md-12 col-sm-12 col-xs-12">
  <img src="/assets/img/Welcome_Transparent.png"
       class="img-responsive center-block col-lg-6 col-md-8 col-sm-10 col-xs-12">

  <h2 class="center-block"> Добро пожаловать, ${user.name}! </h2>
  <h5 align="center-block">Ваш логин на сайте ${user.login}</h5>
  <h6 align="center-block">Теперь Вы можете войти в систему, используя Ваш логин и пароль.</h6>
</div>
<div class="col-lg-8 col-xs-12"></div>
<a href="/">
  <button type="button" class="btn btn-primary btn-md btn-block col-lg-6 col-xs-12">Вернуться на главную</button>
</a>

