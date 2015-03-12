<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<script src="assets/js/jquery.googlemap.js"></script>
<script src="//www.google.fr/jsapi"></script>
<script>
  google.load("maps", "3.4", {
    other_params: "v=AIzaSyAlMDftXoxe0Ig9Dpip_Y0TCuLRWA_TVqg&sensor=false"
  });
</script>

<div class="col-lg-12">
  <div class="bs-component">
    <div class="panel panel-default">
      <div class="panel-body">
        <%--Подключение карты--%>
        <script
            src="https://maps.googleapis.com/maps/api/js?v=AIzaSyAlMDftXoxe0Ig9Dpip_Y0TCuLRWA_TVqg&sensor=false"></script>
        <%--Отображение карыт--%>
        <script>
          var map;
          function initialize() {
            var mapOptions = {
              zoom: 8,
              center: new google.maps.LatLng(48.466169, 35.014089)
            };
            map = new google.maps.Map(document.getElementById('map-canvas'),
                mapOptions);
          }
          google.maps.event.addDomListener(window, 'load', initialize);
        </script>

        <div id="map-canvas" style="height:500px; width:1060px; margin-bottom: 10px;"></div>
        <div class="panel panel-default">
          <div class="panel-body">
            <a class="btn btn-primary" id="btnaddmarker">Add mark</a>
            <a class="btn btn-primary" id="btnaddmarker2">Add mark jquery</a>
          </div>
        </div>

        <%--Добавление маркеров--%>
        <script>
          var latlng = new google.maps.LatLng(48.466169, 35.014089);
          function addmarker(latilongi) {
            var marker = new google.maps.Marker({
              position: latilongi,
              title: 'new marker',
              draggable: true,
              map: map
            });
            map.setCenter(marker.getPosition())
          }

          $('#btnaddmarker').on('click', function () {
            addmarker(latlng)
          })
        </script>
        <%----%>


        <script>
          $('#btnaddmarker2').on('click', function () {
            $(function () {
              $("#map-canvas").googleMap();
              $("#map-canvas").addMarker({
                coords: [48.466169, 35.024089], // GPS coords
//                                    url: 'http://www.tiloweb.com', // Link to redirect onclick (optional)
                id: 'marker1' // Unique ID for your marker
              });
            })
          })
        </script>

        <%--=========================================================--%>
        <%--Форма для добавления точки на карту--%>
        <form id="add-point" action="" method="post">
          <fieldset>
            <legend>Добавить точку на карту</legend>
            <div class="input">
              <label for="name">Название</label>
              <input type="text" name="name" id="name" value="">
            </div>
            <div class="input">
              <label for="address">Адрес</label>
              <input type="text" name="address" id="address" value="">
            </div>
            <button type="submit">Добавить точку</button>
          </fieldset>
        </form>
        <%--<script>--%>
        <%--$("#add-point").submit(function(){--%>
        <%--geoEncode();--%>
        <%--return false;--%>
        <%--});--%>

        <%--var geo = new GClientGeocoder();--%>
        <%--//--%>
        <%--var reasons=[];--%>
        <%--reasons[G_GEO_SUCCESS] = "Информация успешно добавлена";--%>
        <%--//                    reasons[G_GEO_MISSING_ADDRESS] = "Неверный адрес";--%>
        <%--//                    reasons[G_GEO_UNKNOWN_ADDRESS] = "Неизвестный адрес";--%>
        <%--//                    reasons[G_GEO_UNAVAILABLE_ADDRESS]= "Недоступный адрес";--%>
        <%--//                    reasons[G_GEO_BAD_KEY] = "Неверный API-ключ";--%>
        <%--//                    reasons[G_GEO_TOO_MANY_QUERIES] = "Слишком много запросов";--%>
        <%--//                    reasons[G_GEO_SERVER_ERROR] = "Ошибка на сервере";--%>

        <%--function geoEncode() {--%>
        <%--var address = $("#add-point input[name=address]").val();--%>
        <%--geo.getLocations(address, function (result){--%>
        <%--geocode = result.Placemark[0].Point.coordinates;--%>
        <%--savePoint(geocode);--%>

        <%--});--%>
        <%--}--%>

        <%--function addLocation(location) {--%>
        <%--var point = new GLatLng(location.lat, location.lng);--%>
        <%--var marker = new GMarker(point);--%>
        <%--map.addOverlay(marker);--%>
        <%--bounds.extend(marker.getPoint());--%>

        <%--$("<li />")--%>
        <%--.html(location.name)--%>
        <%--.click(function(){--%>
        <%--showMessage(marker, location.name);--%>
        <%--})--%>
        <%--.appendTo("#list");--%>

        <%--GEvent.addListener(marker, "click", function(){--%>
        <%--showMessage(this);--%>
        <%--});--%>
        <%--}--%>
        <%--</script>--%>
      </div>
    </div>
  </div>
</div>