
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Contribuentes Bootstrap e Rubens Matias">
    <meta name="generator" content="Hugo 0.84.0">
    <title>JEE project</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- Custom style para esse template-->
    <link href="https://cdn.jsdelivr.net/gh/rubensdimasjr/cdn/style.css" rel="stylesheet">
</head>

<body>


<!-- Conteúdo -->
<main>
    <div class="position-relative overflow-hidden px-3 p-md-5 m-md-3 text-center bg-light">
        <div class="col-md-5 p-lg-5 mx-auto my-5">
            <h1 class="display-4 fw-normal">Welcome </h1>
            <p class="lead fw-normal"> <p>Get ready to explore a world of innovation and creativity. Our project brings together the best of technology, design, and functionality to provide an amazing experience.</p>
            <p>Start your journey now!</p>
            <a class="btn btn-outline-primary" href="login.jsp">Login</a>
            <a class="btn btn-outline-secondary" href="register.jsp">Inscription</a>
            <a class="btn btn-outline-primary" href="list">Administration</a>


        </div>
        <div class="product-device shadow-sm d-none d-md-block"></div>
        <div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
    </div>


</main>

<!-- footer -->
<footer class="container py-5">
    Made with <span  style="color: red;">&hearts;</span>
</footer>
<!-- Fim footer. -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://kit.fontawesome.com/d13f87c2a3.js" crossorigin="anonymous"></script>

<script>
    $(window).scroll(function(){
        var tamScroll = $(this).scrollTop();

        if(tamScroll >= 30 && $(window).width()>=768){
            $('header').addClass(['bg-white','sombra', 'py-md-3', 'px-md-3']).fadeIn();
            $('header').removeClass(['py-md-5','px-md-5']);
        }else{
            $('header').removeClass(['bg-white','sombra','py-md-3', 'px-md-3']).fadeOut();
            $('header').addClass(['py-md-5','px-md-5']);
        }
    });

    // Para mensagem logout
    setTimeout(function () {
        document.getElementById("logout").style.display = "none";
    }, 2000);

</script>
</body>

</html>