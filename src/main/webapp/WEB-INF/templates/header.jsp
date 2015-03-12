<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>

<!-- Navbar -->

<div class="bs-docs-section clearfix">
  <div class="row">
    <div class="col-lg-12">
      <div class="bs-component">
        <nav class="navbar navbar-default">
          <div class="container-fluid">
            <div class="navbar-header">
              <div class="col-md-4" style="margin-top:5%; vertical-align: middle">
                <a href="/">
                  <img class="left-container" src="/assets/img/logo4.png">
                </a>
              </div>
              <div class="col-md-4" style="margin-left: 5%; margin-top: 2%; vertical-align: middle">
                <img class="content" src="/assets/img/banner_header.png">
              </div>
            </div>

            <div class="navbar-right" id="navbar" style="margin-right:3%">
              <ul class="nav navbar-btn navbar-right">
                <%--<li class="dropdown">--%>
                <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Меню--%>
                <%--<span class="caret"></span></a>--%>
                <%--<ul class="dropdown-menu" role="menu">--%>
                <%--<li><a href="#">Action</a></li>--%>
                <%--<li><a href="#">Another action</a></li>--%>
                <%--<li><a href="#">Something else here</a></li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li><a href="#">Separated link</a></li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li><a href="#">One more separated link</a></li>--%>
                <%--</ul>--%>
                <%--</li>--%>

                <li>
                  <a>
                    <button type="button" class="btn btn-info btn-block" aria-label="Right Align">
                      <span class="glyphicon glyphicon-road" aria-hidden="true"></span> Регистрация
                    </button>
                  </a>
                  <a>
                    <button type="button" class="btn btn-info btn-block" aria-label="Right Align">
                      <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> Контакты
                    </button>
                  </a>
                  <%--<a  href="/registration"><img src="/assets/img/button_rega-02.png" height="50"></a>--%>
                  <%--<a  href="#"><img src="/assets/img/button_contact.png" height="50"></a>--%>
                </li>


              </ul>
            </div>

          </div>
        </nav>
      </div>
    </div>
  </div>
</div>
