<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <c:set var="js" value="/assets/js/"/>
  <c:set var="css" value="/assets/css/"/>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <script type="text/javascript" src="${js}jquery-2.1.3.min.js"></script>
  <script type="text/javascript" src="${js}moment-with-locales.min.js"></script>
  <script type="text/javascript" src="${js}bootstrap.js"></script>
  <script type="text/javascript" src="${js}bootstrap-datetimepicker.js"></script>
  <script type="text/javascript" src="${js}validateTrip.js"></script>
  <link rel="stylesheet" href="${css}bootstrap.min.css"/>
  <link rel="stylesheet" href="${css}bootstrap-datetimepicker.min.css"/>
</head>
<body>
<div class="container">
  <h1>Let`s create a trip</h1>
  <form:form method="post" modelAttribute="trip">
    <fieldset>
      <table cellspacing="0">
        <tr>
          <td>
            <div>Введите количество мест:</div>
            <form:select path="carCapacity" items="${list}"/>
          </td>
        </tr>
        <tr>
          <td>
            <div>Установите стоимость проезда:</div>
            <form:select path="price" items="${list}"/>
          </td>
        </tr>
        <tr>
          <td>
            <div>Установите дату и время старта поездки</div>
            <div class="form-group">
              <!-- Элемент HTML с id равным datetimepicker1 -->
              <div class="input-group date" id="datetimepicker1">
                <input type="text" class="form-control" name="startDate"/>
                            <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                            </span>
              </div>
            </div>

            <!-- Инициализация виджета "Bootstrap datetimepicker" -->
            <script type="text/javascript">
              $(function () {
                //Идентификатор элемента HTML (например: #datetimepicker1), для которого необходимо инициализировать виджет "Bootstrap datetimepicker"
                $('#datetimepicker1').datetimepicker(
                    {
                      language: 'ru',
                      minDate: new Date()
                    }
                );
              });
            </script>
          </td>
        </tr>
        <tr>
          <td>
            <div>Установите контрольные точки</div>
          </td>
        </tr>
        <tr>
          <td>
            <h4>
              <c:forEach var="point" items="${points}" varStatus="status">
                <c:if test="${point.left()}">
                  <input type="checkbox" name="passengerNodePoints[${status.index}].id" value="${point.id}"/>
                  <%--<form:checkbox path="passengerNodePoints[${status.index}].id" label="${point.description}" value="${point.id}"/>--%>
                  <c:out value="${point.description}"/><br>
                </c:if>
              </c:forEach>
                <%--<form:checkboxes items="${points}" path="passengerNodePoints[0].id" itemLabel="description" itemValue="id" delimiter="<br/>"/>--%>
            </h4>
          </td>
          <td>
            <h4>
              <c:forEach var="point" items="${points}" varStatus="status">
                <c:if test="${!point.left()}">
                  <input type="checkbox" name="passengerNodePoints[${status.index}].id" value="${point.id}"/>
                  <%--<form:checkbox path="passengerNodePoints[${status.index}].id" label="${point.description}" value="${point.id}"/>--%>
                  <c:out value="${point.description}"/><br>
                </c:if>
              </c:forEach>
            </h4>
          </td>
        </tr>
        <tr>
          <td>
            <button type="submit">Сохранить
            </button>
          </td>
        </tr>
      </table>
    </fieldset>
  </form:form>
</div>
</body>
</html>