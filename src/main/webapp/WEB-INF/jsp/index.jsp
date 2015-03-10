<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>

<c:url value="/assets/img/" var="images"/>


<!--Banner-->
<div id="banner">
    <div class="row">
        <div class="col-lg-8 col-md-7 col-sm-6 col-xs-6">
            <h1>EasyGo</h1>

            <p class="lead">Have a nice trip!</p>
        </div>
        <div class="col-lg-4 col-md-5 col-sm-6 col-xs-6">
            <hr/>
            <img class="center-block" src="${images}footer_logo_3.png" alt="EsyGo">
        </div>
    </div>
</div>

<hr/>

<div class="bs-docs-section">

    <!-- Slider -->
    <div class="row">
        <div class="col-lg-8">
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
                                    <img src="${images}slider-img-1.jpg" alt="slider1">

                                </div>
                                <div class="item">
                                    <img src="${images}slider-img-2.jpg" alt="slider2">

                                </div>
                                <div class="item">
                                    <img src="${images}slider-img-3.jpg" alt="slider3">

                                </div>
                                <div class="item">
                                    <img src="${images}slider-img-4.jpg" alt="slider4">

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


        <div class="col-lg-4">
            <div class="bs-component">
                <div class="panel panel-info">
                    <div class="panel-heading">Log In</div>
                    <div class="panel-body">
                        <div class="well bs-component">

                            <c:url value="/j_spring_security_check" var="loginUrl"/>


              <form class="form-horizontal" action="${loginUrl}" method="post">
                <fieldset>
                  <%--<legend></legend>--%>
                  <br/>

                  <div class="form-group">
                    <div class="col-lg-12">
                      <input type="text" class="form-control" id="inputEmail1"
                             name="j_username" placeholder="Login">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-12">
                      <input type="password" class="form-control" id="inputEmail"
                             name="j_password"
                             placeholder="Password">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-12">
                      <!--<button type="reset" class="btn btn-default">Registration</button>-->
                      <a class="btn btn-info" href="/registration">Регистрация</a>
                      <button type="submit" class="btn btn-primary pull-right">Вход</button>
                    </div>
                  </div>
                </fieldset>
              </form>
              <hr/>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--content-->
    <div class="row">
        <div class="col-lg-12">
            <div class="bs-component">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>main content</h2>

            <p>
              Raw denim you probably haven't heard of them jean shorts Austin.
              Nesciunt tofu stumptown aliqua, retro synth master cleanse.
              Mustache cliche tempor, williamsburg carles vegan helvetica.
              Reprehenderit butcher retro keffiyeh dreamcatcher synth.
              Cosby sweater eu banh mi, qui irure terry richardson ex squid.
              Aliquip placeat salvia cillum iphone.
              Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.
            </p>

            <p>
              Raw denim you probably haven't heard of them jean shorts Austin.
              Nesciunt tofu stumptown aliqua, retro synth master cleanse.
              Mustache cliche tempor, williamsburg carles vegan helvetica.
              Reprehenderit butcher retro keffiyeh dreamcatcher synth.
              Cosby sweater eu banh mi, qui irure terry richardson ex squid.
              Aliquip placeat salvia cillum iphone.
              Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.
            </p>

            <p>
              Raw denim you probably haven't heard of them jean shorts Austin.
              Nesciunt tofu stumptown aliqua, retro synth master cleanse.
              Mustache cliche tempor, williamsburg carles vegan helvetica.
              Reprehenderit butcher retro keffiyeh dreamcatcher synth.
              Cosby sweater eu banh mi, qui irure terry richardson ex squid.
              Aliquip placeat salvia cillum iphone.
              Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.
            </p>

                        <p>
                            Raw denim you probably haven't heard of them jean shorts Austin.
                            Nesciunt tofu stumptown aliqua, retro synth master cleanse.
                            Mustache cliche tempor, williamsburg carles vegan helvetica.
                            Reprehenderit butcher retro keffiyeh dreamcatcher synth.
                            Cosby sweater eu banh mi, qui irure terry richardson ex squid.
                            Aliquip placeat salvia cillum iphone.
                            Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.
                        </p>

                        <p>
                            Raw denim you probably haven't heard of them jean shorts Austin.
                            Nesciunt tofu stumptown aliqua, retro synth master cleanse.
                            Mustache cliche tempor, williamsburg carles vegan helvetica.
                            Reprehenderit butcher retro keffiyeh dreamcatcher synth.
                            Cosby sweater eu banh mi, qui irure terry richardson ex squid.
                            Aliquip placeat salvia cillum iphone.
                            Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.
                        </p>

        <%--map google--%>
        <div class="col-lg-6">
            <div class="bs-component">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>Map</h2>

                        <script
                                src="https://maps.googleapis.com/maps/api/js?v=AIzaSyAlMDftXoxe0Ig9Dpip_Y0TCuLRWA_TVqg&sensor=false"></script>
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
                        <div id="map-canvas" style="height:300px; width:515px"></div>

                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
</div>
