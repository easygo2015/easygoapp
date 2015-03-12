

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>

<c:set var="js" value="/assets/js/"/>
<c:set var="css" value="/assets/css/"/>
<script src="${js}validate.js"></script>
<script src="${js}showModals.js"></script>
<link rel="stylesheet" href="${css}animate.css">
<link rel="stylesheet" href="${css}style.css">
<h1>Редактировать профиль</h1>

        <div class="well bs-component">
            <div class="row">
                <div class="col-lg-7">
                    <sf:form class="form-horizontal" method="post" modelAttribute="user" role="form">
                        <fieldset>
                            <sf:input path="password" type="hidden"/>
                            <sf:input path="login" type="hidden"/>
                            <div class="form-group" >
                                <label class="control-label col-sm-2" for="fullname">Имя:</label>

                                <div class="col-sm-10">
                                    <sf:input path="name" id="fullname" class="form-control" placeholder="Введите имя"/>
                                    <span id="nameError" class="center-block hidden text-danger">минимум 3 символа</span>
                                </div>
                            </div>
                            <div class="form-group" id="blockemail">
                                <label class="control-label col-sm-2" for="email">E-mail:</label>

                                <div class="col-sm-10">
                                    <sf:input path="email" id="email" class="form-control"
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
                                    <sf:input path="car" id="car" class="form-control"
                                              placeholder="Введите описание машины"/>
                                </div>
                            </div>
                        </fieldset>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <button type="submit" id="send" class="btn btn-info pull-right">Сохранить</button>
                            </div>
                        </div>
                    </sf:form>
                </div>
                <div class="col-lg-5">
                    <div class="list-group">
                        <p class="list-group-item list-group-item-info">
                            Меню
                        </p>
                        <a href="#" id="changePassword" class="list-group-item">Сменить пароль</a>
                        <a href="#" id="deleteProfile" class="list-group-item">Удалить профиль</a>
                        <a href="/user" class="list-group-item">На мою страницу</a>
                    </div>
                    <div id="deleteContent" class="panel panel-info displayNone">
                        <div class="panel-heading">
                            <p class="panel-title">Вы уверены?</p>
                        </div>
                        <div class="panel-body">
                            <a class="btn btn-sm btn-danger" href="/user/editProfile/deleteProfile">Удалить</a>
                            <a class="btn btn-sm btn-info" href="#" id="continue">Остаться</a>
                        </div>
                    </div>
                    <div id="changeContent" class="panel panel-info displayNone">
                        <div class="panel-heading">
                            <p class="panel-title">Смена пароля</p>
                        </div>
                        <div class="panel-body">
                            <sf:form role="form" method="post" modelAttribute="pass" action="/user/editProfile/changePassword">
                                <fieldset>
                                    <div class="form-group form-group-sm" id="blockoldpass">
                                        <label for="currentPassword"><small>Текущий пароль:</small></label>
                                        <sf:input path="currentPassword" type="password" class="form-control input-sm" id="currentPassword" placeholder="Введите текущий пароль"/>
                                    </div>
                                    <div class="form-group form-group-sm" id="blockpassword">
                                        <label for="password"><small>Новый пароль:</small></label>
                                            <sf:input path="newPassword" type="password" class="form-control input-sm" id="password" placeholder="Введите новый пароль"/>
                                    </div>
                                    <div class="form-group form-group-sm" id="blockcompare">
                                        <label for="compas"><small>Подтверждение:</small></label>
                                        <input type="password" class="form-control input-sm" id="compas" placeholder="Подтвердите новый пароль">
                                    </div>
                                    <div class="form-group form-group-sm pull-right">
                                        <button type="reset" class="btn btn-sm btn-warning" id="cancel">Отмена</button>
                                        <button type="submit" class="btn btn-sm btn-info" id="sendPass" onclick="showMessage()">Сохранить</button>
                                    </div>
                                </fieldset>
                            </sf:form>
                        </div>
                    </div>
                    <c:set var="classDisplay" value="displayNone"></c:set>
                    <c:if test="${not empty mes}">
                        <c:set var="classDisplay" value=""></c:set>
                    </c:if>
                    <div id="message" class="${classDisplay} alert alert-success" role="alert">
                        <p>Password successfully changed!</p>
                    </div>
                </div>
            </div>
        </div>





