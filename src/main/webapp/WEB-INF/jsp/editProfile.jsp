<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <c:set var="js" value="/assets/js/"/>
  <meta charset="UTF-8">
  <title>EasyGo</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <script src="${js}validate.js"></script>
    <script src="${js}showModals.js"></script>
  <!-- CSS
  ================================================== -->
  <link rel="stylesheet" href="/assets/css/bootstrap.css">
  <![endif]-->
</head>
<head>
  <title></title>
</head>
<body>
<div class="container">
  <h1>Редактировать профиль</h1>

  <div class="row">
    <div class="col-lg-12">
      <div class="well bs-component">
        <div class="row">
          <div class="col-lg-9">
            <sf:form class="form-horizontal" method="post" modelAttribute="user" role="form">
              <fieldset>
                <sf:input path="password" value="${user.password}" type="hidden"/>
                <sf:input path="login" value="${user.login}" type="hidden"/>
                <div class="form-group">
                  <label class="control-label col-sm-2" for="fullname">Имя:</label>

                  <div class="col-sm-10">
                    <sf:input path="name" id="fullname" class="form-control" value="${user.name}"
                              placeholder="Введите имя"/>
                    <span id="nameError" class="center-block hidden text-danger">минимум 3 символа</span>
                  </div>
                </div>
                <div class="form-group" id="blockemail">
                  <label class="control-label col-sm-2" for="email">E-mail:</label>

                  <div class="col-sm-10">
                    <sf:input path="email" id="email" class="form-control" value="${user.email}"
                              placeholder="Введите e-mail"/>
                    <span id="emailError" class="center-block hidden text-danger"> пример: rob@gmail.com </span>
                  </div>
                </div>
                <div class="form-group" id="blockphone">
                  <label class="control-label col-sm-2" for="phone">Телефон:</label>

                  <div class="col-sm-10">
                    <sf:input path="phoneNumber" id="phone" class="form-control" value="${user.phoneNumber}"
                              placeholder="Введите телефон"/>
                    <span id="phoneError" class="center-block hidden text-danger"> пример: 8 050 333 22 11</span>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-sm-2" for="sex">Пол:</label>

                  <div class="col-sm-10" id="sex">
                    <sf:radiobutton path="gender" value="FEMALE"/>Женщина
                    <sf:radiobutton path="gender" value="MALE"/>Мужчина
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-sm-2" for="car">Машина:</label>

                  <div class="col-sm-10">
                    <sf:input path="car" id="car" class="form-control" value="${user.car}"
                              placeholder="Введите описание машины"/>
                  </div>
                </div>
              </fieldset>
              <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                  <button type="submit" id="send" class="btn btn-primary pull-right">Сохранить</button>
                </div>
              </div>
            </sf:form>
          </div>
          <div class="col-lg-3">
            <div class="btn-group-vertical btn-block center-block">
              <a class="btn btn-success" href="#">Сменить пароль</a>
              <a class="btn btn-warning" id="deleteLink" href="#">Удалить профиль</a>
              <a class="btn btn-info" href="/user">На мою страницу</a>
            </div>
            <div id="deleteMessage" class="well bg-success" style="display:none">
              <p class="center-block text-warning">Вы уверены?</p>
              <a class="btn btn-danger" href="/user/editProfile/deleteProfile">Удалить</a>
              <a class="btn btn-success" href="#" id="continue">Остаться</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
