<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h1>Let`s create a trip</h1>
<form:form method="post" modelAttribute="trip">
    <fieldset>
        <table cellspacing="0">
            <tr>
                <td><div>Введите количество мест:</div>
                    <form:input path="carCapacity" id="capasity"/>
                </td>
            </tr>
            <tr>
                <td><div>Установите стоимость проезда:</div>
                    <form:input path="price"/>
                </td>
            </tr>
            <tr>
                <td><div>Установите контрольные точки</div>
                </td>
            </tr>
            <tr>
                <td>
                    <h4>
                        <c:set var="count" value="0" scope="page"/>
                        <c:forEach var="point" items="${points}" varStatus="status">
                            <c:if test="${point.isLeft()}">
                                <input type="checkbox" name="passengerNodePoints[${status.index}].id" value="${point.id}"/>
                                <%--<form:checkbox path="passengerNodePoints[${status.index}].id" label="${point.description}" value="${point.id}"/>--%>
                               <%--// <c: count="${count+1}"/>--%>
                                <c:out value="${point.description}"/><br>
                            </c:if>
                        </c:forEach>
                        <%--<form:checkboxes items="${points}" path="passengerNodePoints[0].id" itemLabel="description" itemValue="id" delimiter="<br/>"/>--%>
                    </h4>
                </td>
                <td>
                    <h4>
                        <%--<c:forEach var="point" items="${points}">--%>
                        <%--<c:if test="${!point.isLeft()}">--%>
                            <%--<input type="checkbox" name="${count + 1}">--%>
                            <%--<c:out value="${point.getDescription()}"/><br>--%>
                        <%--</c:if>--%>
                        <%--</c:forEach>--%>
                    </h4>
                </td>
            </tr>
            <tr>
                <td><button type="submit">Сохранить
                </button>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>