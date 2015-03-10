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
    <c:set var="js" value="/assets/js/"/>
    <script src="${js}validate.js"></script>
    <script src="${js}showModals.js"></script>
</head>
<body>
<div class="container">
    <h1>ADMIN'S ROOM</h1>

    <div class="col-lg-12">
        <div class="bs-component">
            <table class="table table-striped table-hover ">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Login</th>
                    <th>Car</th>
                    <th>Phone</th>
                    <th>Email</th>
                </tr>
                </thead>
                <c:forEach var="user" items="${requestScope.usersList}">
                    <tbody>
                    <tr class="info">
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.gender}</td>
                        <td>${user.login}</td>
                        <td>${user.car}</td>
                        <td>${user.phoneNumber}</td>
                        <td>${user.email}</td>
                        <td>
                            <form:form class="form-inline" action="/admin/userlist/edit" method="get"
                                       commandName="editUser">
                                <button type="submit" class="btn btn-primary pull-right">Edit User</button>
                                <input type="hidden" name="id" value="${user.id}">
                            </form:form>
                        </td>
                        <td>
                            <form:form class="form-inline" id="deleteLink" action="/admin/userlist/delete" method="get"
                                       commandName="deleteUser">
                                <button type="submit" class="btn btn-primary pull-right">Delete User</button>
                                <input type="hidden" name="id" value="${user.id}">
                            </form:form>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>


    <form class="form-horizontal" action="/admin/usersList" method="get">
        <div class="form-group">
            <button type="submit" class="btn btn-primary pull-right">View users</button>
        </div>
    </form>
    <form class="form-horizontal" action="/admin/pointsList" method="get">
        <div class="form-group">
            <button type="submit" class="btn btn-primary pull-right">View points</button>
        </div>
    </form>
</div>
</body>
</html>
