<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>

<h1>Моя страница</h1>

<div class="row">
  <div class="col-lg-12">
    <div class="well bs-component">
      <div class="row">
        <div class="col-lg-6">
          <p class="bg-info"><span class="glyphicon glyphicon-user"></span>&nbsp&nbsp${user.login}</p>
          <table class="table">
            <thead>
            <tr>
              <th></th>
              <th></th>
            </tr>
            </thead>
            <tbody>
            <tr class="success">
              <td>Имя:</td>
              <td>${user.name}</td>
            </tr>
            <tr class="active">
              <td>Пол:</td>
              <td>
                <c:choose>
                  <c:when test="${user.gender=='MALE'}">
                    Мужчина
                  </c:when>
                  <c:otherwise>
                    Женщина
                  </c:otherwise>
                </c:choose>
              </td>
            </tr>
            <tr class="info">
              <td>E-mail:</td>
              <td>${user.email}</td>
            </tr>
            <tr class="warning">
              <td>Телефон:</td>
              <td>${user.phoneNumber}</td>
            </tr>
            <tr class="success">
              <td>Машина:</td>
              <td>
                <c:choose>
                  <c:when test="${empty user.car}">
                    нет
                  </c:when>
                  <c:otherwise>
                    ${user.car}
                  </c:otherwise>
                </c:choose>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
        <div class="col-lg-6">
          <div class="btn-group-vertical btn-block center-block">
            <a class="btn btn-primary" href="/user/showTrips">Мои поездки</a>
            <a class="btn btn-success" href="/user/findTrip">Найти поездку</a>
            <c:choose>
              <c:when test="${empty user.car}">
              </c:when>
              <c:otherwise>
                <a class="btn btn-info" href="/user/createTrip">Создать поездку</a>
              </c:otherwise>
            </c:choose>
            <a class="btn btn-warning" href="/user/editProfile">Редактировать профиль</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<a href="<c:url value="/j_spring_security_logout" />">
  <button type="button" class="btn btn-primary btn-lg">Logout</button>
</a>
</div>
</body>
</html>