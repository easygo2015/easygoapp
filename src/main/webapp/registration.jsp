<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>EasyGo Bootstrap</title>
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
                                <a class="navbar-brand" href="/main">EasyGo</a>
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
                                    <li class="active"><a href="/main">Регистрация <span class="sr-only">(current)</span></a></li>
                                    <li><a href="#">Контакты</a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>

<!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->


    <div class="bs-docs-section">
        <div class="row">
            <div class="col-lg-12">
                <div class="page-header">
                    <h1 id="forms">Регистрация</h1>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="well bs-component">
                    <form:form class="form-horizontal" id="form" action="/main" method="get" modelAttribute = "user">
                        <!---->
                        <fieldset>
                            <legend>Персональная информация</legend>
                            <div class="form-group" id="login">
                                <label for="login" class="col-lg-2 control-label">Логин:</label>
                                <div class="col-lg-10">
                                    <form:input type="text" path="login" class="form-control" id="enterlogin" placeholder="Введите логин"/>
                                    <span id="loginError" class="center-block hidden text-danger">минимум 3 символа</span>
                                    <span id="loginError2" class="center-block hidden text-danger">такой логин уже зарегестрирован</span>
                                </div>
                            </div>

                            <div class="form-group" id="name">
                                <label for="fullname" class="col-lg-2 control-label">Имя:</label>
                                <div class="col-lg-10">
                                    <form:input type="text" path="name" class="form-control" id="fullname" placeholder="Введите ваше имя"/>
                                    <span id="nameError" class="center-block hidden text-danger">минимум 3 символа</span>
                                </div>
                            </div>

                            <div class="form-group" id="gender">
                                <label class="col-lg-2 control-label">Пол:</label>
                                <div class="col-lg-10">
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="gender" id="female" value="female"/>
                                            Женщина
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="gender" id="male" value="male"/>
                                            Мужчина
                                        </label>
                                    </div>
                                    <span id="genderError" class="center-block hidden text-danger"> сделайте выбор </span>
                                </div>
                            </div>

                            <div class="form-group" id="car">
                                <label class="col-lg-2 control-label">Машина:</label>
                                <div class="col-lg-10">
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="car" value="idonthave"/>
                                            Нет машины
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="car" value="ihave"/>
                                            Есть машина
                                        </label>
                                    </div>
                                    <span id="carError" class="center-block hidden text-danger">Есть ли у вас машина?</span>
                                    <div class="col-lg-5" id="info">
                                        <input type="text" class="form-control hidden" id="aboutcar" placeholder="Введите марку и цвет машины">
                                        <span id="infocar" class="center-block hidden text-danger">минимум 3 символа</span>
                                    </div>

                                </div>
                            </div>
                        </fieldset>

                        <hr/>

                        <fieldset>
                            <legend>Контакты</legend>
                            <div class="form-group" id="blockemail">
                                <label for="email" class="col-lg-2 control-label">Email:</label>
                                <div class="col-lg-10">
                                    <form:input path="email" type="text" class="form-control" name="email" id="email" placeholder="Email"/>
                                    <span id="emailError" class="center-block hidden text-danger"> пример: rob@gmail.com </span>
                                </div>
                            </div>


                            <div class="form-group" id="blockphone">
                                <label for="phone" class="col-lg-2 control-label">Телефон:</label>
                                <div class="col-lg-10">
                                    <form:input path="phoneNumber" type="text" class="form-control" name="phone" id="phone" placeholder="Телефон"/>
                                    <span id="phoneError" class="center-block hidden text-danger"> пример: 8 050 333 22 11</span>
                                </div>
                            </div>
                        </fieldset>

                        <hr/>

                        <fieldset>
                            <legend>Security</legend>
                            <div class="form-group" id="blockpassword">
                                <label for="password" class="col-lg-2 control-label">Пароль:</label>
                                <div class="col-lg-10">
                                    <form:input path="password" type="password"  class="form-control" name="password" id="password" placeholder="Password"/>
                                    <span id="passwordError" class="center-block hidden text-danger"> пароль слишком короткий, минимум 3 символа </span>
                                </div>
                            </div>

                            <div class="form-group" id="blockcompare">
                                <label for="compas" class="col-lg-2 control-label">Подтверждение:</label>
                                <div class="col-lg-10">
                                    <input type="password" class="form-control" name="compas" id="compas" placeholder="Password">
                                    <span id="comError" class="center-block hidden text-danger"> пароль не совпадает </span>
                                </div>
                            </div>
                        </fieldset>

                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="submit" id="send" class="btn btn-primary pull-right">Submit</button>
                                </div>
                            </div>
                    </form:form>
                </div>
            </div>

        </div>
    </div>



<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->



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

<!--<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>-->
<script src="assets/js/jquery-2.1.3.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/validate.js"></script>
</body>
</html>