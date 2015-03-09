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
  <link rel="stylesheet" href="/assets/css/bootstrap.css">
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <div class="col-lg-12 col-md-12">
      <div class="h1" align="center">Мои поездки</div>
    </div>
  </div>
</div>
<c:if test="${tripsDriver.size()>0}">
  <div class="container-fluid">
    <div class="row">
      <div class="col-lg-1 col-md-1"></div>
      <div class="col-lg-10 col-md-10">
        <div class="h4">Поездки, где я пилот</div>
        <table class="table table-bordered table-hover table-striped">
          <tr>
            <th>№</th>
            <th>Время старта поездки</th>
            <th>Количество свободных мест</th>
            <th>Стоимость проезда</th>
            <th>Маршрут</th>
            <th></th>
          </tr>
          <c:forEach var="trip" varStatus="count" items="${tripsDriver}">
            <tr>
              <td><c:out value="${count.index+1}"/></td>
              <td><c:out value="${trip.startTime}"/></td>
              <td><c:out value="${trip.carCapacity}"/></td>
              <td><c:out value="${trip.price}"/></td>
              <td><c:forEach var="tripPoint" items="${trip.passengerNodePoints}">
                <div><c:out value="${tripPoint.description}"/></div>
              </c:forEach>
              </td>
              <td>
                <a href="/user/showTrips/deleteTrip?id=${trip.id}">
                  <button type="button" class="btn btn-danger btn-sm">Удалить поездку</button>
                </a>
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
      <div class="col-lg-1 col-md-1"></div>
    </div>
  </div>
</c:if>

<br>

<c:if test="${tripsPassenger.size()>0}">
  <div class="container-fluid">
    <div class="row">
      <div class="col-lg-1 col-md-1"></div>
      <div class="col-lg-10 col-md-10">
        <div class="h4">Поездки, где я пассажир</div>
        <table class="table table-bordered table-hover table-striped">
          <tr>
            <th>№</th>
            <th>Время старта поездки</th>
            <th>Количество свободных мест</th>
            <th>Стоимость проезда</th>
            <th>Маршрут</th>
            <th></th>
          </tr>
          <c:forEach var="trip" varStatus="count" items="${tripsPassenger}">
            <tr>
              <td><c:out value="${count.index+1}"/></td>
              <td><c:out value="${trip.startTime}"/></td>
              <td><c:out value="${trip.carCapacity}"/></td>
              <td><c:out value="${trip.price}"/></td>
              <td><c:forEach var="tripPoint" items="${trip.passengerNodePoints}">
                <div><c:out value="${tripPoint.description}"/></div>
              </c:forEach>
              </td>
              <td>
                <a href="/showTrips/declineTrip?id=${trip.id}">
                  <button type="button" class="btn btn-danger btn-sm">Отказаться от поездки</button>
                </a>
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
      <div class="col-lg-1 col-md-1"></div>
    </div>
  </div>
</c:if>
</body>
</html>