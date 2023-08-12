<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Users</h3>
        <button type="/index.jsp" class="btn btn-outline-primary">return</button>

        <hr>
        <form
                class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"action="<%=request.getContextPath()%>/search" method="get">
            <div class="input-group">


                <input type="text" name="motCle" value="${motCle}" class="form-control bg-light border-0 small" placeholder="Search for..."
                       aria-label="Search" aria-describedby="basic-addon2">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit" type="button">
                        <i class="fas fa-search"></i></button>
                </div>
            </div>
        </form>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-outline-primary">Add
                New User</a>
            <a href="<%=request.getContextPath()%>/list" class="btn btn-outline-secondary">Users</a>
        </div>

        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Password</th>
                <th>Number</th>
                <th>Action</th>

            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="user" items="${listUser}">

                <tr>
                    <td>
                        <c:out value="${user.iduser}" />
                    </td>
                    <td>
                        <c:out value="${user.username}" />
                    </td>
                    <td>
                        <c:out value="${user.email}" />
                    </td>
                    <td>
                        <c:out value="${user.password}" />
                    </td>
                    <td>
                        <c:out value="${user.number}" />
                    </td>
                    <td><a href="edit?id=<c:out value='${user.iduser}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${user.iduser}' />">Delete</a></td>

                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>

</html>