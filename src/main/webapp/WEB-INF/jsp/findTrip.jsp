<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<div class="bs-docs-section">
  <div class="row">
    <div class="col-lg-12">
      <div class="page-header">
        <h3 id="type">Поиск поездки</h3>
      </div>
    </div>
  </div>
  <div class="row">
    <%--Google Map--%>
    <div class="col-lg-12">
      <div class="bs-component">
        <div class="panel panel-default">
          <div class="panel-body">
            <%--<h2>Map</h2>--%>
            <div id="map-canvas" style="height:400px; width:100%"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-4">
      <%--Forms--%>
      <form:form method="post" modelAttribute="dto">
      <div class="bs-component">
        <div class="panel panel-default">
          <div class="panel-body">
            Укажите интервал времени, когда Вы хотите найти поезду
            <hr/>
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
              <h4>До:</h4>

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
        </div>
      </div>
    </div>
    <div class="col-lg-4">
      <div class="bs-component">
        Выберите подходящий Вам маршрут!<br/>
        Левый берег:
        <hr/>
        <div class="h5">
          <c:forEach var="point" items="${points}" varStatus="status">
            <c:if test="${point.isLeft()}">
              <input type="checkbox" name="passengerNodePoints[${status.index}].id"
                     value="${point.id}"/>
              <c:out value="${point.description}"/><br>
            </c:if>
          </c:forEach>
        </div>
      </div>
    </div>
    <div class="col-lg-4">
      <div class="bs-component">
        Выберите подходящий Вам маршрут!<br/>
        Правый берег:
        <hr/>
        <div class="h5">
          <c:forEach var="point" items="${points}" varStatus="status">
            <c:if test="${!point.isLeft()}">
              <input type="checkbox" name="passengerNodePoints[${status.index}].id"
                     value="${point.id}"/>
              <c:out value="${point.description}"/><br>
              <c:set value="${point.description}" var="descrypt"></c:set>
              <%--<c:out value="${point.latitude}"/><br>--%>
              <c:set value="${point.latitude}" var="latSpan"></c:set>
              <%--<c:out value="${point.longitude}"/><br>--%>
              <c:set value="${point.longitude}" var="lngSpan"></c:set>
            </c:if>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
  <button type="submit" class="btn btn-primary btn-lg btn-block">Поиск</button>
  </form:form>
</div>
<%--Таблица для вывода--%>
<div class="bs-docs-section">
  <div class="row">
    <div class="col-lg-12">
      <div class="page-header">
        <h1 id="tables">Расписание поездок</h1>
      </div>
      <div class="bs-component">
        <table class="table table-bordered table-striped table-hover ">
          <thead>
          <tr>
            <th>№</th>
            <th>Время старта поездки</th>
            <th>Количество свободных мест</th>
            <th>Стоимость проезда</th>
            <th>Маршрут</th>
            <th>Совпадения по маршруту</th>
            <th>Занять место</th>
          </tr>
          </thead>
          <tbody>
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
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<%--Script for map--%>
<script src="https://maps.googleapis.com/maps/api/js?v=AIzaSyAlMDftXoxe0Ig9Dpip_Y0TCuLRWA_TVqg&sensor=false"></script>
<script>
  var map;
  function initialize() {
    var myLatlng = new google.maps.LatLng(48.466169, 35.014089);
    var mapOptions = {
      zoom: 10,
      center: myLatlng,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    setMarkers(map, places);
  }
  var lat = '${latSpan}';
  var lng = '${lngSpan}';
  var des = '${descrypt}';
  var places = [
    [des, lat, lng],
    ['Ул. Димитрова', 48.509504, 34.589525],
    ['Пр. Пелина', 48.522354, 34.605061],
    ['Ул. Сыровца', 48.516299, 34.606681],
    ['Площадь Ленина', 48.516057, 34.61226]
  ];
  function setMarkers(map, locations) {
    for (var i = 0; i < locations.length; i++) {
      var beach = locations[i];
      var myLatLng = new google.maps.LatLng(beach[1], beach[2]);
      var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: beach[0]
      });
    }
  }
  google.maps.event.addDomListener(window, 'load', initialize);
</script>