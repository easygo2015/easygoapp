<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <c:set var="js" value="/assets/js/"/>
  <c:set var="css" value="/assets/css/"/>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <script type="text/javascript" src="${js}jquery-2.1.3.min.js"></script>
  <script type="text/javascript" src="${js}moment-with-locales.min.js"></script>
  <script src="${js}bootstrap.js"></script>
  <script type="text/javascript" src="${js}bootstrap-datetimepicker.js"></script>
  <script type="text/javascript" src="${js}validateTrip.js"></script>
  <link rel="stylesheet" href="${css}bootstrap.css">
  <link rel="stylesheet" href="${css}bootstrap-datetimepicker.min.css"/>
  <link rel="stylesheet" href="${css}custom.css"/>
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <div class="col-lg-12 col-md-12">
      <div class="h1" align="center">Поиск поездки</div>
    </div>
  </div>
</div>
<div class="container-fluid">
  <div class="row">
    <div class="col-lg-1 col-md-1"></div>
    <div class="col-lg-5 col-md-5">
      <form:form method="post" modelAttribute="dto">
        <fieldset>
          <div class="h4">Укажите интервал времени, когда Вы хотите найти поезду</div>
          <div class="row">
            <div class="col-lg-5 col-md-5">
              <div class="form-group">
                <div class="h4">От:</div>
                <div class="input-group date" id="datetimepicker1">
                  <form:input path="startTime" type="text" class="form-control"/>
                            <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                </div>
              </div>
              <script type="text/javascript">
                $(function () {
                  $('#datetimepicker1').datetimepicker(
                      {
                        language: 'ru',
                        defaultDate: new Date(),
                        minDate: new Date()
                      }
                  );
                });
              </script>
              <div class="form-group">
                <div class="h4">До:</div>
                <div class="input-group date" id="datetimepicker2">
                  <form:input path="endTime" type="text" class="form-control"/>
                            <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                </div>
              </div>
              <script type="text/javascript">
                $(function () {
                  $('#datetimepicker2').datetimepicker(
                      {
                        language: 'ru',
                        defaultDate: new Date(),
                        minDate: new Date()
                      }
                  );
                });
              </script>
            </div>
            <div class="col-lg-7 col-md-7"></div>
          </div>
          <div class="h4">Выберите пункты маршрута, наиболее совпадающие с Вашими местом посадки и пунктом назначения:
          </div>
          <div class="row">
            <div class="col-lg-7 col-md-7">
              <div class="h3">Левый берег:</div>
              <div class="h5">
                <c:forEach var="point" items="${points}" varStatus="status">
                  <c:if test="${point.isLeft()}">
                    <input type="checkbox" name="passengerNodePoints[${status.index}].id" value="${point.id}"/>
                    <c:out value="${point.description}"/><br>
                  </c:if>
                </c:forEach>
              </div>
            </div>
            <div class="col-lg-5 col-md-5">
              <div class="h3">Правый берег:</div>
              <div class="h5">
                <c:forEach var="point" items="${points}" varStatus="status">
                  <c:if test="${!point.isLeft()}">
                    <input type="checkbox" name="passengerNodePoints[${status.index}].id" value="${point.id}"/>
                    <c:out value="${point.description}"/><br>
                  </c:if>
                </c:forEach>
              </div>
            </div>
          </div>
          <button type="submit" class="btn btn-info btn-md">Поиск</button>
        </fieldset>
      </form:form>
    </div>
    <div class="col-lg-5 col-md-5">
      <img src="assets/img/slider-img-1.jpg">
    </div>
    <div class="col-lg-5 col-md-5"></div>
  </div>
</div>
<div class="container-fluid">
  <div class="h1" align="center">Результаты поиска</div>
  <div class="row">
    <div class="col-md-1 col-lg-1"></div>
    <div class="col-md-10 col-lg-10">
      <table class="table table-bordered table-hover table-striped">
        <tr>
          <th>№</th>
          <th>Время старта поездки</th>
          <th>Количество свободных мест</th>
          <th>Стоимость проезда</th>
          <th>Маршрут</th>
          <th>Совпадения по маршруту</th>
          <th></th>
        </tr>
        <c:forEach var="trip" varStatus="count" items="${dto.trips}">
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
              <c:forEach var="tripPoint" items="${trip.passengerNodePoints}">
                <c:forEach var="userPoint" items="${dto.passengerNodePoints}">
                  <c:if test="${tripPoint.id == userPoint.id}">
                    <div><c:out value="${tripPoint.description}"/></div>
                  </c:if>
                </c:forEach>
              </c:forEach>
            </td>
            <td>
              <a href="/user/findTrip/saveTrip?id=${trip.id}">
                <button type="button" class="btn btn-info btn-sm">Занять место</button>
              </a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
    <div class="col-md-1 col-lg-1"></div>
  </div>
</div>

</body>
</html>