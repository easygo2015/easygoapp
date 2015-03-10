<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>

<div class="container">
    <div class="col-lg-10">
        <a class="btn btn-warning" href="/admin/addPoint">Add new Passenger Node Point</a>
    </div>
    <c:forEach var="point" items="${points}" varStatus="status">
        <div class="col-lg-6">
            <c:out value="${point.description}"/><br>
            <sf:form class="form-inline" id="deleteLink" action="/admin/pointsList/delete" method="get"
                       commandName="deletePoint">
                <button type="submit" class="btn btn-primary pull-right">Delete Point</button>
                <input type="hidden" name="id" value="${point.id}">
            </sf:form>
        </div>
    </c:forEach>
</div>