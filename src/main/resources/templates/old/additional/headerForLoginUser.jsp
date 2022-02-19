<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon-->
    <link rel="shortcut icon" href="<c:url value="/img/fav.png"/>">
    <!-- Author Meta -->
    <meta name="author" content="colorlib">
    <!-- Meta Description -->
    <meta name="description" content="">
    <!-- Meta Keyword -->
    <meta name="keywords" content="">
    <!-- meta character set -->
    <meta charset="UTF-8">
    <!-- Site Title -->
    <title>JNews</title>

    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
    <!--
    CSS
    ============================================= -->
    <link rel="stylesheet" href="<c:url value="/css/linearicons.css"/>" >
    <link rel="stylesheet" href="<c:url value="/css/font-awesome.min.css"/>" >
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>" >
    <link rel="stylesheet" href="<c:url value="/css/magnific-popup.css"/>" >
    <link rel="stylesheet" href="<c:url value="/css/jquery-ui.css"/>" >
    <link rel="stylesheet" href="<c:url value="/css/nice-select.css"/>" >
    <link rel="stylesheet" href="<c:url value="/css/animate.min.css"/>" >
    <link rel="stylesheet" href="<c:url value="/css/owl.carousel.css"/>" >
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>" >
</head>
    <body>



            <header id="header">
            <div class="container main-menu">
        <div class="row align-items-center justify-content-between d-flex">
            <div id="logo">
                <a href="/user/dashboard"><img src="<c:url value="/img/logo.png"/>" alt="" title="" /></a>
            </div>
            <nav id="nav-menu-container">
                <ul class="nav-menu">
                    <li><a href="/user/weather">Weather BETA</a></li>
                    <li><a href="/user/edit">Edit</a></li>
                    <li><a href="/user/contact">Contact</a></li>
                    <li><form action="/logout" method="post" class="alert-dark">
                        <button type="submit">Logout</button>
                    </form></li>

                </ul>
            </nav><!-- #nav-menu-container -->
        </div>
    </div>
</header>
    <!-- #header -->