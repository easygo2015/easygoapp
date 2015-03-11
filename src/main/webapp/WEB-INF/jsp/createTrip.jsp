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
<link rel="stylesheet" href="${css}custom.css"/>


<div class="bs-docs-section">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h3 id="type">Создание поездки</h3>
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
            <%--form--%>
            <form:form method="post" modelAttribute="trip">
            <div class="bs-component">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="form-group">
                            <label class="col-lg-10 control-label ">Выберите количество мест:</label>
                            <form:select path="carCapacity" items="${list}"/>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-10 control-label ">Укажите стоимость проезда:</label>
                            <form:select path="carCapacity" items="${list}"/>
                        </div>
                        <hr/>

                        <p>Установите дату и время старта поездки:</p>

                        <div class="form-group">
                            <!-- Элемент HTML с id равным datetimepicker1 -->
                            <div class="input-group date" id="datetimepicker1">
                                <input type="text" class="form-control" name="startDate"/>
                                        <span class="input-group-addon">
                                          <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                            </div>
                        </div>

                        <!-- Инициализация виджета "Bootstrap datetimepicker" -->
                        <script type="text/javascript">
                            $(function () {
                                //Идентификатор элемента HTML (например: #datetimepicker1), для которого необходимо инициализировать виджет "Bootstrap datetimepicker"
                                $('#datetimepicker1').datetimepicker(
                                        {
                                            language: 'ru',
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
                Установите контрольные точки!<br/>
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
                Установите контрольные точки!<br/>
                Правый берег:
                <hr/>
                <div class="h5">
                    <c:forEach var="point" items="${points}" varStatus="status">
                        <c:if test="${!point.isLeft()}">
                            <input type="checkbox" name="passengerNodePoints[${status.index}].id"
                                   value="${point.id}"/>
                            <c:out value="${point.description}"/><br>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            <button type="submit" class="btn btn-info btn-lg btn-block">Сохранить</button><br>
        </div>
        </form:form>
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
        [des, lat, lng ],
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