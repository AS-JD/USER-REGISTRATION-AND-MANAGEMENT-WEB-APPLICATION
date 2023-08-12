<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<section class="vh-100">

    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                     class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form action="<%= request.getContextPath() %>/login" method="post">
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <input type="email" id="useremail" class="form-control form-control-lg"
                               placeholder="Enter a valid email address" />
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <input type="password" id="userpsw" class="form-control form-control-lg"
                               placeholder="Enter password" />
                    </div>
                    <div class="text-center text-lg-start mt-4 pt-2">

                        <input  class="btn btn-primary btn-lg"
                               style="padding-left: 2.5rem; padding-right: 2.5rem;" type="submit"
                               name="submit" value="Enter">
                        <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="register.jsp"
                                                                                          class="link-danger">Register</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- Include Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
