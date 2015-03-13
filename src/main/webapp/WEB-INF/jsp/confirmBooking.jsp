

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>

<c:set var="js" value="/assets/js/"/>
<c:set var="css" value="/assets/css/"/>
<script src="${js}validate.js"></script>
<script src="${js}showModals.js"></script>
<link rel="stylesheet" href="${css}animate.css">
<link rel="stylesheet" href="${css}style.css">
<h1>Потверждение брони</h1>

<div class="well bs-component">
    <div class="row">
        <div class="col-lg-7">
            <table class="table">
                <tbody>
                <tr class="whiteBackground">
                    <td>Время старта поездки:</td>
                    <td>${trip.startTime}</td>
                </tr>
                <tr class="whiteBackground">
                    <td>Стоимость проезда:</td>
                    <td>${trip.price}</td>
                </tr>
                </tbody>
            </table>
            <c:forEach var="tripPoint" items="${trip.passengerNodePoints}">
                    <c:if test="${tripPoint.left == true}">
                        <div><c:out value="${tripPoint.description}"/></div>
                    </c:if>
            </c:forEach>
            
        </div>
        <div class="col-lg-5">

        </div>
    </div>
</div>





