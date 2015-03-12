<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09.03.15
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>

<c:set var="js" value="/assets/js/"/>
<script src="${js}validate.js"></script>
<script src="${js}showModals.js"></script>
<link rel="stylesheet" href="/assets/css/animate.css">
<link rel="stylesheet" href="/assets/css/style.css">
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
                  <sf:input path="name" id="fullname" class="form-control" placeholder="Введите имя"/>
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
                  <sf:input path="phoneNumber" id="phone" class="form-control" placeholder="Введите телефон"/>
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
            <a id="changePassword" class="btn btn-success" href="/user/editProfile/changePassword">Сменить пароль</a>
            <a id="deleteProfile" class="btn btn-warning" href="#">Удалить профиль</a>
            <a class="btn btn-info" href="/user">На мою страницу</a>
          </div>
          <div id="deleteContent" class="well bg-success displayNone">
            <p class="center-block text-warning">Вы уверены?</p>
            <a class="btn btn-danger" href="/user/editProfile/deleteProfile">Удалить</a>
            <a class="btn btn-success" href="#" id="continue">Остаться</a>
          </div>


          <c:choose>
            <c:when test="${empty message}">
              <c:set var="show" value="displayNone"/>
            </c:when>
            <c:otherwise>
              <c:set var="show" value=""/>
            </c:otherwise>
          </c:choose>
          <div id="changeContent" class="well bg-success ${show}">
            <sf:form role="form" method="post" modelAttribute="modelMap" action="/user/editProfile/changePassword">
              <fieldset>
                  <%--<input type="password" id="compareCurrent" value="${user.password}" type="hidden">--%>
                <div class="form-group form-group-sm" id="blockoldpass">
                  <label for="currentPassword">
                    <small>Текущий пароль:</small>
                  </label>
                  <input type="password" class="form-control input-sm" id="currentPassword"
                         placeholder="Введите текущий пароль">
                </div>
                <div class="form-group form-group-sm" id="blockpassword">
                  <label for="password">
                    <small>Новый пароль:</small>
                  </label>
                    <%--<sf:input path="modelMap['newPassword']" type="password" class="form-control input-sm" id="password" placeholder="Введите новый пароль"/>--%>
                </div>
                <div class="form-group form-group-sm" id="blockcompare">
                  <label for="compas">
                    <small>Подтверждение:</small>
                  </label>
                  <input type="password" class="form-control input-sm" id="compas"
                         placeholder="Подтвердите новый пароль">
                </div>
                <div class="form-group form-group-sm">
                  <div class="row">
                    <div class="col-lg-6">
                      <button type="reset" class="btn btn-sm btn-warning" id="cancel">Отмена</button>
                    </div>
                    <div class="col-lg-6">
                      <button type="submit" class="btn btn-sm btn-info">Сохранить</button>
                    </div>
                  </div>
                </div>
              </fieldset>
            </sf:form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


