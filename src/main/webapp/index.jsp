<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>EasyGo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="assets/css/bootstrap.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="container">

          <!-- Navbar -->
          <div class="bs-docs-section clearfix">
            <div class="row">
                <div class="col-lg-12">
                    <div class="bs-component">
                        <nav class="navbar navbar-default">
                            <div class="container-fluid">
                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                    <a class="navbar-brand active" href="/main">EasyGo <span class="sr-only">(current)</span></a>
                                </div>

                                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                    <ul class="nav navbar-nav navbar-right">
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Меню <span class="caret"></span></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Action</a></li>
                                                <li><a href="#">Another action</a></li>
                                                <li><a href="#">Something else here</a></li>
                                                <li class="divider"></li>
                                                <li><a href="#">Separated link</a></li>
                                                <li class="divider"></li>
                                                <li><a href="#">One more separated link</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">О нас</a></li>
                                        <li><a href="/registration">Регистрация </a></li>
                                        <li><a href="#">Контакты</a></li>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>


          <!--Banner-->
          <div  id="banner">
            <div class="row">
                <div class="col-lg-8 col-md-7 col-sm-6 col-xs-6">
                    <h1>Мы заботимся о Вашей комфортной поездке</h1>
                </div>
                <div class="col-lg-4 col-md-5 col-sm-6 col-xs-6">
                    <hr/>
                    <img class="center-block" src="assets/img/footer_logo_3.png"  alt="EsyGo">
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
                                        <img src="assets/img/slider-img-1.jpg" alt="slider1">
                                        <div class="carousel-caption">
                                            slider 1
                                        </div>
                                    </div>
                                    <div class="item">
                                        <img src="assets/img/slider-img-2.jpg" alt="slider2">
                                        <div class="carousel-caption">
                                            slider 2
                                        </div>
                                    </div>
                                    <div class="item">
                                        <img src="assets/img/slider-img-3.jpg" alt="slider3">
                                        <div class="carousel-caption">
                                            slider 3
                                        </div>
                                    </div>
                                    <div class="item">
                                        <img src="assets/img/slider-img-4.jpg" alt="slider4">
                                        <div class="carousel-caption">
                                            slider 4
                                        </div>
                                    </div>
                                </div>
                                <!-- Controls -->
                                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                </a>
                                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
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
                                <form class="form-horizontal">
                                    <fieldset>
                                        <legend></legend>
                                        <div class="form-group">
                                            <!--<label for="inputEmail" class="col-lg-2 control-label">Name</label>-->
                                            <div class="col-lg-12">
                                                <input type="text" class="form-control" id="inputEmail1" placeholder="Login">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <!--<label for="inputEmail" class="col-lg-2 control-label">Password</label>-->
                                            <div class="col-lg-12">
                                                <input type="text" class="form-control" id="inputEmail" placeholder="Password">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-12">
                                                <!--<button type="reset" class="btn btn-default">Registration</button>-->
                                                <a class="btn btn-info" href="/registration">Регистрация</a>
                                                <button type="submit" class="btn btn-primary pull-right">Submit</button>
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
                                <p>
                                    Raw denim you probably haven't heard of them jean shorts Austin.
                                    Nesciunt tofu stumptown aliqua, retro synth master cleanse.
                                    Mustache cliche tempor, williamsburg carles vegan helvetica.
                                    Reprehenderit butcher retro keffiyeh dreamcatcher synth.
                                    Cosby sweater eu banh mi, qui irure terry richardson ex squid.
                                    Aliquip placeat salvia cillum iphone.
                                    Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


          <footer>
            <div class="row">
                <div class="col-lg-11">
                    <div class="bs-component">
                        <div class="well">
                            footer!
                        </div>
                    </div>
                </div>
                <div class="col-lg-1">
                    <div class="bs-component">
                        <div class="well">
                            <a href="#top">up!</a>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

    </div>

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</body>
</html>