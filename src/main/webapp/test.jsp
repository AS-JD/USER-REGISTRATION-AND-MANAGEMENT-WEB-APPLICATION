<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<ul>
    <c:forEach items="${userList}" var="user">
        <li>ID: ${user.id}, Email: ${user.useremail}</li>
    </c:forEach>
</ul>
</body>
</html>
