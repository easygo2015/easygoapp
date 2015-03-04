<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h1>Trip info</h1>
<h6>${message.toString()}</h6>
<h1>Companions</h1>
<h4>
<c:forEach var="companion" items="${message.getCompanions()}">
        <c:out value="${companion.toString()}"/><br>
</c:forEach>
</h4>
<h1>Points</h1>
<h4>
    <c:forEach var="point" items="${message.getPassengerNodePoints()}">
        <c:out value="${point.toString()}"/><br>
    </c:forEach>
</h4>
</body>
</html>