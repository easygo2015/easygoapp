<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<div class="row">
    <div class="col-lg-12 col-md-12">
        <div class="h1" align="center">Мои поездки</div>
    </div>
</div>

<c:if test="${tripsDriver.size()>0}">

    <div class="row">
        <div class="col-lg-12 col-md-12">
            <div class="h4">Поездки, где я водитель</div>
            <table class="table table-bordered table-hover table-striped text-center">
                <tr>
                    <th class="text-center">№</th>
                    <th class="text-center">Время старта поездки</th>
                    <th class="text-center">Количество свободных мест</th>
                    <th class="text-center">Стоимость проезда</th>
                    <th class="text-center">Попутчик/место посадки</th>
                    <th class="text-center">Удалить поездку</th>
                </tr>
                <c:forEach var="trip" varStatus="count" items="${tripsDriver}">
                    <tr>
                        <td><c:out value="${count.index+1}"/></td>
                        <td><c:out value="${trip.startTime}"/></td>
                        <td><c:out value="${trip.carCapacity}"/></td>
                        <td><c:out value="${trip.price}"/></td>
                        <td><c:forEach var="landing" items="${trip.getPassengerLanding()}">
                            <div><c:out
                                    value="Имя: ${landing.getUser().name}, номер телефона:"/></div>
                            <div><c:out
                                    value=" ${landing.getUser().phoneNumber}, место посадки: "/></div>
                            <div><c:out value=" ${landing.description}"/></div>
                            <br>
                        </c:forEach>
                        </td>
                        <td>
                            <a href="/user/showTrips/deleteTrip?id=${trip.id}">
                                <button type="button" class="btn btn-danger btn-sm">Удалить
                                    поездку
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</c:if>

<br>

<c:if test="${tripsPassenger.size()>0}">

    <div class="row">
        <div class="col-lg-12 col-md-12">
            <div class="h4">Поездки, где я попутчик</div>
            <table class="table table-bordered table-hover table-striped text-center">
                <tr>
                    <th class="text-center">№</th>
                    <th class="text-center">Время старта поездки</th>
                    <th class="text-center">Стоимость проезда</th>
                    <th class="text-center">Маршрут</th>
                    <th class="text-center">Водитель</th>
                    <th class="text-center">Отказаться от поездки</th>
                </tr>
                <c:forEach var="trip" varStatus="count" items="${tripsPassenger}">
                    <tr>
                        <td><c:out value="${count.index+1}"/></td>
                        <td><c:out value="${trip.startTime}"/></td>
                        <td><c:out value="${trip.price}"/></td>
                        <td><c:forEach var="tripPoint" items="${trip.passengerNodePoints}">
                            <div><c:out value="${tripPoint.description}"/></div>
                        </c:forEach>
                        </td>
                        <td>
                            <div><c:out value=" Имя: ${trip.driver.name}, номер телефона:"/></div>
                            <div><c:out value=" ${trip.driver.phoneNumber}"/></div>
                        </td>
                        <td>
                            <a href="/user/showTrips/declineTrip?id=${trip.id}">
                                <button type="button" class="btn btn-danger btn-sm">Отказаться
                                    от поездки
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</c:if>
<a href="/user">
    <button type="button" class="btn btn-primary btn-lg">Вернуться на страницу пользователя</button>
</a>
<hr/>
