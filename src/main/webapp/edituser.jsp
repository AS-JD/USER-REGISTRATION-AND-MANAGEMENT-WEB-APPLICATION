<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
  <title>Modification des utilisateurs</title>
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
  <div class="card">
    <div class="card-header">
      Modification des utilisateurs
    </div>
    <div class="card-body">
      <form action="update.do" method="post">
        <c:if test="${not empty user.iduser}">
          <div class="form-group" hidden>
            <label class="control-label">ID :</label>
            <input type="text" name="id" class="form-control" value="${user.iduser}" />
          </div>
        </c:if>
        <div class="form-group">
          <label class="control-label">Nom :</label>
          <input type="text" name="username" class="form-control" value="${user.username}" />
        </div>
        <div class="form-group">
          <label class="control-label">Password :</label>
          <input type="text" name="userpsw" class="form-control" value="${user.password}" />
        </div>
        <div class="form-group">
          <label class="control-label">Email :</label>
          <input type="text" name="useremail" class="form-control" value="${user.email}" />
        </div>
        <div class="form-group">
          <label class="control-label">Number :</label>
          <input type="text" name="number" class="form-control" value="${user.number}" />
        </div>
        <div>
          <button type="submit" class="btn btn-primary">Modifier</button>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
