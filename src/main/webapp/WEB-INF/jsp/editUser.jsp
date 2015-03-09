<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
</head>
<body>
<c:set var="userToEdit" value="${requestScope.userToEdit}"/>

<div class="container">
  <form:form class="form-horizontal" id="editUserForm" method="post" commandName="user">
    <form:hidden path="password"/>
    <form:hidden path="id"/>
    <fieldset>
      <legend>User Details</legend>
      <div class="form-group">
      </div>
      <div class="form-group">
        <label class="col-lg-2 control-label">User Login</label>

        <div class="col-lg-10">
          <form:input path="login"/>
        </div>
      </div>
      <div class="form-group">
        <label for="inputEmail" class="col-lg-2 control-label">User email</label>

        <div class="col-lg-10">
          <input type="text" class="form-control" id="inputEmail" placeholder="Email" value="${userToEdit.email}">
        </div>

        <div class="form-group">
          <label class="col-lg-2 control-label">Gender</label>

          <div class="col-lg-10">
            <div class="radio">
              <label>
                <input type="radio" name="inputGender" id="male" value="1" checked="">
                Male
              </label>
            </div>
            <div class="radio">
              <label>
                <input type="radio" name="inputGender" id="female" value="0">
                Female
              </label>
            </div>
          </div>
        </div>

        <div class="form-group">
          <label for="inputName" class="col-lg-2 control-label">User Name</label>

          <div class="col-lg-10">
            <input type="text" class="form-control" id="inputName" placeholder="Name" value="${userToEdit.name}">
          </div>
        </div>

        <div class="form-group">
          <label for="inputPhone" class="col-lg-2 control-label">Phone number</label>

          <div class="col-lg-10">
            <input type="text" class="form-control" id="inputPhone" placeholder="Phone"
                   value="${userToEdit.phoneNumber}">
          </div>
        </div>


      </div>
      <div class="form-group">
        <label for="inputCar" class="col-lg-2 control-label">Car description</label>

        <div class="col-lg-10">
          <textarea class="form-control" rows="3" id="inputCar"></textarea>
        <span
            class="help-block">${userToEdit.car}</span>
        </div>
      </div>

      <div class="form-group">
        <div class="col-lg-10 col-lg-offset-2">
          <button type="reset" class="btn btn-default">Cancel</button>
          <button type="submit" class="btn btn-primary">Edit User</button>
        </div>
      </div>
    </fieldset>
  </form:form>
</div>
</body>
</html>
