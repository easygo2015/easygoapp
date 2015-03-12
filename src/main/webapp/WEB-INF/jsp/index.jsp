<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>

<c:url value="/assets/img/" var="images"/>
<c:url value="/assets/js/" var="js"/>
<c:url value="/assets/js/" var="css"/>

<!-- Slider -->

<div class="row">
    <div class="col-lg-8 col-xs-12">
        <div class="bs-component">
            <div class="panel panel-default">
                <div class="panel-body">

                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img class="img-responsive" src="${images}slider-img-1.jpg" alt="slider1">

                            </div>
                            <div class="item">
                                <img class="img-responsive" src="${images}slider-img-2-rs.jpg" alt="slider2">

                            </div>
                            <div class="item">
                                <img class="img-responsive" src="${images}slider-img-3.jpg" alt="slider3">

                            </div>
                            <div class="item">
                                <img class="img-responsive" src="${images}slider-img-4.jpg" alt="slider4">

                                <div class="carousel-caption">
                                </div>
                            </div>
                        </div>
                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" role="button"
                           data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" role="button"
                           data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
        <div class="col-lg-4 col-xs-12">
            <div class="bs-component">

                    <%--<div class="well bs-component">--%>

                <c:url value="/j_spring_security_check" var="loginUrl"/>


                <form class="form-horizontal" action="${loginUrl}" method="post">
                    <fieldset>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <input type="text" class="form-control" id="inputEmail1"
                                       name="j_username" placeholder="Логин">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <input type="password" class="form-control" id="inputEmail"
                                       name="j_password"
                                       placeholder="Пароль">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <button type="submit" class="btn btn-info btn-block">Вход</button>
                                <a class="btn btn-info btn-block" href="/registration">Регистрация</a>
                            </div>
                        </div>
                        <div class="col-xs-12">
                            <p>Регистрируясь на сайте</p>
                        </div>
                    </fieldset>
                </form>
                    <%--</div>--%>

            </div>
        </div>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <div class="col-lg-4 col-xs-12">
            <div class="bs-component">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">Информация о пользователе</h3>
                    </div>
                    <div class="panel-body" align="center">
                        Вы вошли как <sec:authentication property="principal.username"/><br><br>
                    </div>
                </div>
            </div>
        </div>
    </sec:authorize>
</div>

<!--content-->
<div class="row">
    <div class="col-lg-12 col-xs-12">
        <div class="bs-component">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h2>Добро пожаловать!</h2>

                    <p>
                        Вы живете в восхитительном городе Днепродзержинске на левом берегу?
                        Если ответ утвердительный, значит, благодаря данному сайту, вы сможете значительно облегчить
                        себе жизнь.
                    </p>

                    <h3>Итак, чем же мы Вас сможем заинтересовать?</h3>

                    <p>
                        Вы наверняка знаете, какие «прекрасные» очереди необходимо простоять на маршрутку, чтобы уехать
                        на правый
                        берег в утреннее время.
                        Главная задача нашего сервиса – облегчить жизнь:
                        Тому, кто добирается утром на работу на маршрутках.
                        Больше Вам не нужно будет вставать на час раньше, чтобы простоять «Великую» очередь на маршрутку
                        и уехать
                        на правый берег.
                        Тому, кто добирается на правый берег на личном авто без попутчиков.
                    </p>

                    <h3>Что мы предлагаем?</h3>
                    <h4>Зарегистрировавшись на нашем сайте. Вы сможете:</h4>

                    <p>
                        Находить поездки в нужное для Вас время. Также Вы сможете указывать наиболее популярные места
                        посадки и
                        высадки пассажиров на левом и правом берегах нашего города, что значительно облегчит Ваш поиск с
                        выбором
                        поездки.
                        В случае, если у Вас есть авто, создавать поездки. При этом Вы сможете выбрать основные точки
                        Вашего
                        маршрута,
                        задавать время старта, устанавливать количество свободных мест в каждой поездке, а также
                        адекватную
                        стоимость проезда.
                        Благодаря этому Вы сможете не только окупить проезд на правый берег, но также помочь людям
                        добраться
                        вовремя на работу.
                        Кто знает, может Вы сможете найти попутчиков, которые проживают по соседству с Вами.
                    </p>
                </div>
            </div>
        </div>
    </div>

    <%--&lt;%&ndash;map google&ndash;%&gt;
    <div class="col-lg-6 col-xs-12">
      <div class="bs-component">
        <div class="panel panel-default">
          <div class="panel-body">
            <h2>Карта</h2>
            <script
                src="https://maps.googleapis.com/maps/api/js?v=AIzaSyAlMDftXoxe0Ig9Dpip_Y0TCuLRWA_TVqg&sensor=false"></script>
            <script>
              var map;
              function initialize() {
                var mapOptions = {
                  zoom: 8,
                  center: new google.maps.LatLng(48.523117, 34.613683)
                };
                map = new google.maps.Map(document.getElementById('map-canvas'),
                    mapOptions);
              }
              google.maps.event.addDomListener(window, 'load', initialize);
            </script>
            <div class="img-responsive" id="map-canvas" style="height:350px; width:620px"></div>
          </div>
        </div>
      </div>
    </div>--%>
</div>
</div>



