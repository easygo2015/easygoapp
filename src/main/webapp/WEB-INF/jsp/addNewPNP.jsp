<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <c:set var="js" value="/assets/js/"/>
    <meta charset="UTF-8">
    <title>EasyGo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <script src="${js}validatePoint.js"></script>
    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="/assets/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="col-lg-6">
        <sf:form class="form-horizontal" method="post" modelAttribute="point" role="form">
            <fieldset>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="latitude">Широта</label>

                    <div class="col-sm-10">
                        <sf:input path="latitude" id="latitude" class="form-control" value=""
                                  placeholder="Введите широту"/>
                        <span id="latitudeError"
                              class="center-block hidden text-danger">должна быть числом 12.345678</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="longitude">Широта</label>

                    <div class="col-sm-10">
                        <sf:input path="longitude" id="longitude" class="form-control" value=""
                                  placeholder="Введите долготу"/>
                        <span id="longitudeError"
                              class="center-block hidden text-danger">должна быть числом 12.345678</span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="isLeft">Берег Днепра</label>

                    <div class="col-sm-10" id="isLeft">
                        <sf:radiobutton path="isLeft" value="true"/>Левый
                        <sf:radiobutton path="isLeft" value="false"/>Правый
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="description">Широта</label>

                    <div class="col-sm-10">
                        <sf:input path="description" id="description" class="form-control" value=""
                                  placeholder="Введите долготу"/>
                        <span id="descriptionError" class="center-block hidden text-danger">не менее 3 символов</span>
                    </div>
                </div>
            </fieldset>

            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <button type="submit" id="send" class="btn btn-primary pull-right">Сохранить</button>
                </div>
            </div>
        </sf:form>
    </div>
</div>
</body>