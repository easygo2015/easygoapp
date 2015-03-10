<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>EasyGo</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <!-- CSS
  ================================================== -->
  <link rel="stylesheet" href="/assets/css/bootstrap.css">
  <![endif]-->
</head>
<head>
  <title></title>
</head>
<body>
<div class="container">
  <h1>ADMIN'S ROOM</h1>

  <form class="form-horizontal" action="${loginUrl}" method="post">
    <fieldset>
      <legend></legend>
      <div class="form-group">

        <button type="submit" class="btn btn-primary pull-right">View users</button>

      </div>
    </fieldset>
  </form>
</div>
</body>
</html>
