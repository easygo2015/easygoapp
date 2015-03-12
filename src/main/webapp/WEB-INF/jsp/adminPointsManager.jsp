<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>
<script src="/assets/js/deleteNotify.js"></script>

<div class="container">
  <div class="col-lg-10">
    <a class="btn btn-warning" href="/admin/addPoint">Add new Passenger Node Point</a>
  </div>


  <table class="table table-striped table-hover ">
    <thead>
    <tr>
      <th>Lattitude</th>
      <th>Longitude</th>
      <th>Description</th>
    </tr>
    </thead>

    <c:forEach var="point" items="${points}" varStatus="status">
      <tbody>
      <tr class="info">
        <td>${point.latitude}</td>
        <td>${point.longitude}</td>
        <td>${point.description}</td>
      </tr>
      </tbody>
    </c:forEach>
  </table>
</div>