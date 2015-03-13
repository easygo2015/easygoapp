<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<link rel="stylesheet" href="/assets/css/custom.css">

<!-- Navbar -->
<div class="row">
  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
    <div class="bs-component">
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-left col-lg-10 col-md-9 col-sm-12">
            <div id="banner">
              <a href="/">
                <img class="img-responsive" src="/assets/img/banner_header_full.svg">
              </a>
            </div>
          </div>
          <%--<div class="bs-component">--%>
          <div class="navbar-right col-lg-2 col-md-3 col-sm-12" id="navbar">
            <ul class="nav navbar-btn">
              <li>
                <sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
                  <a href="/registration">
                    <button type="button" class="btn btn-info btn-block"
                            aria-label="Right Align">
                      <span class="glyphicon glyphicon-road" aria-hidden="true"></span>
                      Регистрация
                    </button>
                  </a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                  <a>
                    <a href="<c:url value="/j_spring_security_logout" />">
                      <button type="button" class="btn btn-info btn-block"><span
                          class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
                        Выйти
                      </button>
                    </a>
                  </a>
                </sec:authorize>
                <a href="/about">
                  <button type="button" class="btn btn-info btn-block" aria-label="Right Align">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    О проекте
                  </button>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  </div>
</div>
